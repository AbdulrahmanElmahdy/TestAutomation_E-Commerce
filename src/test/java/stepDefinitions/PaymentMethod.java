package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class PaymentMethod {

    @Given("select check or money order")
    public static void selectPaymentOption() {
        ClickChoose_Locators.paymentOption(driver).click();
    }

    @And("click continue")
    public static void clickContinuePayment() {
        ClickChoose_Locators.clickContinuePaymentOption(driver).click();
    }

    @When("payment information tab opened")
    public static void paymentConfirmationDisplayed() throws IOException {
        test = extent.createTest("Validate that the payment confirm tab is displayed", "User validate payment options selected successfully with displaying the confirmation tab");
        boolean paymentConfirmationTab = ClickChoose_Locators.paymentConfirmationDisplayed(driver).isDisplayed();
        if (paymentConfirmationTab) {
            test.log(Status.PASS, "Test Passed, Payment option successfully selected");
        } else {
            test.log(Status.FAIL, "Test Failed, Payment option selection failed");
            screenshotEvidence();
        }
        Assert.assertTrue(paymentConfirmationTab);
    }

    @And("click continue again")
    public static void clickContinueConfirmation() {
        ClickChoose_Locators.clickContinuePaymentConfirmation(driver).click();
    }

    @When("confirm order tab is displayed")
    public static void confirmOrderDisplayed() throws IOException {
        test = extent.createTest("Validate that the order confirm tab is displayed and payment confirmation successfully done", "User validate order confirmation tab is displayed");
        boolean orderConfirmationTab = ClickChoose_Locators.confirmOrderDisplayed(driver).isDisplayed();
        if (orderConfirmationTab) {
            test.log(Status.PASS, "Test Passed, Payment confirmation successfully done");
        } else {
            test.log(Status.FAIL, "Test Failed, Payment confirmation failed");
            screenshotEvidence();
        }
        Assert.assertTrue(orderConfirmationTab);
    }

    @And("click confirm button")
    public static void clickConfirmOrder() {
        ClickChoose_Locators.clickConfirmOrder(driver).click();
    }

    @Then("validate the order successfully done and validate order number")
    public static void validateOrderDoneNumber() throws IOException {
        test = extent.createTest("Validate that the order is successfully done", "User validate order is successfully done and order number is displayed");
        boolean orderSuccessMessage = ClickChoose_Locators.orderSuccessfully(driver).isDisplayed();
        boolean orderNumber = ClickChoose_Locators.orderNumber(driver).isDisplayed();
        if (orderSuccessMessage && orderNumber) {
            test.log(Status.PASS, "Test Passed, Order successfully done with an order number");
        } else {
            test.log(Status.FAIL, "Test Failed, Order failed");
            screenshotEvidence();
        }
        Assert.assertTrue(orderSuccessMessage && orderNumber);
    }
}
