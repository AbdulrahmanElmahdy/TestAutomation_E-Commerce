package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import locators.InsertData_Locators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

import static screenshots.ScreenshotsEvidence.screenshotEvidence;
import static hooks.Hooks.*;

public class LoginStepDef {
    @Given("user navigate to login page")
    public static void navigateToLogin() {
        ClickChoose_Locators.login(driver).click();
    }

    @When("user enter valid email and password")
    public static void insertValidUsernamePwd() {

        InsertData_Locators.loginEmailinst(driver).sendKeys("boodi@outlook.com");
        InsertData_Locators.loginPwdinst(driver).sendKeys("Ab@94#22");
    }

    @And("user click on login button")
    public static void clickLoginButton() {
        ClickChoose_Locators.clickLoginButton(driver).click();
    }

    @Then("user login succeed")
    public static void loginSuccess() throws IOException {
        test = extent.createTest("Confirm Login Success", "User validate login is succeed");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(InsertData_Locators.loginValidation(driver)));
        boolean validateLogin = InsertData_Locators.loginValidation(driver).getAttribute("href").contains("/customer/info");
        if (validateLogin) {
            test.log(Status.PASS, "Test Passed, User successfully login");
        } else {
            test.log(Status.FAIL, "Test Failed, User login failed");
            screenshotEvidence();
        }
        Assert.assertTrue(validateLogin);
    }
}
