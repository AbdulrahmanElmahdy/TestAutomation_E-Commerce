package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import locators.InsertData_Locators;
import org.testng.Assert;

import java.io.IOException;

import static screenshots.ScreenshotsEvidence.screenshotEvidence;
import static hooks.Hooks.*;

public class RegistrationStepDef {

    @Given("user navigate to register page")
    public static void navigateToRegisterPage() {
        ClickChoose_Locators.resister(driver).click();
    }

    @When("select gender, fill firstname and lastname")
    public static void fillGenderFNLS() {
        ClickChoose_Locators.gender(driver).click();
        InsertData_Locators.insertFrstName(driver).sendKeys("Abdulrahman");
        InsertData_Locators.insertLasName(driver).sendKeys("Amer");
    }

    @And("choose birthdate day, month, year")
    public static void chooseBirthDate() {
        ClickChoose_Locators.dayDropDown(driver);
        ClickChoose_Locators.monthDropDown(driver);
        ClickChoose_Locators.yearDropDown(driver);
    }

    @Then("insert email, password and confirm password")
    public static void insertEmailPwConPw() {
        InsertData_Locators.email(driver).sendKeys("boodi@outlook.com");
        InsertData_Locators.insertPwd(driver).sendKeys("Ab@94#22");
        InsertData_Locators.insertPwdConf(driver).sendKeys("Ab@94#22");
    }

    @And("click on register button")
    public static void clickRegButton() {
        ClickChoose_Locators.clickReg(driver).click();
    }

    @Then("successful register message appears")
    public static void confirmMessage() throws IOException {
        test = extent.createTest("Confirm Registration Message", "User validate registration completed message is displayed");
        boolean result = InsertData_Locators.confirmationMessage(driver).getText().contentEquals("Your registration completed");
        if (result) {
            test.log(Status.PASS, "Test Passed, Confirmation message is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, registration failed");
            screenshotEvidence();
        }
        Assert.assertTrue(result);
    }

}
