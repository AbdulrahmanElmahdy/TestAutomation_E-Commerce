package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import locators.InsertData_Locators;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class ResetPwdStepDef {

    @Given("navigate to login page")
    public static void navigateLoginPage() throws InterruptedException {
        Thread.sleep(4000);
        ClickChoose_Locators.login(driver).click();
    }

    @When("click on forget password")
    public static void clickForgetPassword() {
        ClickChoose_Locators.forgetPwd(driver).click();
    }

    @And("insert email")
    public static void insertEmail() {
        InsertData_Locators.emailForgetPwd(driver).sendKeys("boodi@outlook.com");
    }

    @And("click on recover button")
    public static void clickRecoverButton() {
        ClickChoose_Locators.recoverButton(driver).click();
    }

    @Then("confirm send to mail message appears")
    public static void confirmMessage() throws InterruptedException, IOException {
        test = extent.createTest("Validate mail message displayed", "User validate the message that reset link sent to the mail is displayed");
        Thread.sleep(4000);
        boolean result = driver.findElement(By.className("content")).getText().contentEquals("Email with instructions has been sent to you.");
        if (result) {
            test.log(Status.PASS, "Test Passed, mail successfully sent");
        } else {
            test.log(Status.FAIL, "Test Failed, mail sending failed");
            screenshotEvidence();
        }
        Assert.assertTrue(result);
    }

}
