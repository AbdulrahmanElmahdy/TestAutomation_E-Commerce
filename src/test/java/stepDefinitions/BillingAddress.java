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

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class BillingAddress {

    @Given("update checkout details")
    public static void updateCheckOutDetails() {
        ClickChoose_Locators.clickShoppingCart(driver).click();
    }

    @And("validate the first name, last name, and email is filled")
    public static void validateFieldsAutomaticallyFilled() throws IOException {
        test = extent.createTest("Validate that the order is done successfully", "User validate message for order successfully done is displayed");
        String firstNameField = InsertData_Locators.validateFirstName(driver).getAttribute("value");
        String lastNameField = InsertData_Locators.validateLastName(driver).getAttribute("value");
        String emailField = InsertData_Locators.validateEmail(driver).getAttribute("value");
        if (firstNameField != null && lastNameField != null && emailField != null) {
            test.log(Status.PASS, "Test Passed, Fields is filled automatically");
        } else if (firstNameField == null && lastNameField == null && emailField == null) {
            InsertData_Locators.firstNameBilling(driver).sendKeys("Abdulrahman");
            InsertData_Locators.lastNameBilling(driver).sendKeys("Amer");
            InsertData_Locators.emailBilling(driver).sendKeys("boodi@outlook.com");
            test.log(Status.PASS, "Test Passed, Fields is filled successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Order failed");
            screenshotEvidence();
        }
        Assert.assertNotNull(firstNameField);
        Assert.assertNotNull(lastNameField);
        Assert.assertNotNull(emailField);
    }

    @When("select country from the list")
    public static void selectCountry() {
        ClickChoose_Locators.selectCountry(driver);
    }

    @And("insert the city name")
    public static void insertCity() {
        InsertData_Locators.insertCity(driver).sendKeys("Cairo");
    }

    @And("insert detailed address")
    public static void insertAddress() {
        InsertData_Locators.insertAddress(driver).sendKeys("Hadayek Maadi 9St");
    }

    @And("insert the postal code")
    public static void insertPostalCode() {
        InsertData_Locators.insertPostalCode(driver).sendKeys("16942");
    }

    @And("insert the phone number")
    public static void insertPhoneNumber() {
        InsertData_Locators.insertPhoneNumber(driver).sendKeys("01012489630");
    }

    @And("click on continue button")
    public static void clickContinueBilling() {
        ClickChoose_Locators.clickContinueBilling(driver).click();
    }

    @Then("validate the payment method is displayed")
    public static void paymentMethodTabDisplayed() throws IOException {
        boolean paymentTab = ClickChoose_Locators.paymentMethodDisplayed(driver).isDisplayed();
        if (paymentTab) {
            test.log(Status.PASS, "Test Passed, Billing address successfully added");
        } else {
            test.log(Status.FAIL, "Test Failed, Billing address added failed");
            screenshotEvidence();
        }
        Assert.assertTrue(paymentTab);
    }


}
