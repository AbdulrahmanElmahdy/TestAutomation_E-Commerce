package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import locators.ClickChoose_Locators;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class CheckoutPage {

    @Given("click continue to confirm order")
    public static void clickOnCart() {
        ClickChoose_Locators.clickShoppingCart(driver).click();
    }

    @And("click on checkbox to agree terms")
    public static void checkOnAgreeTermsBox() {
        ClickChoose_Locators.acceptTerms(driver).click();
    }

    @And("click on checkout button")
    public static void clickOnCheckout() {
        ClickChoose_Locators.clickCheckOut(driver).click();
    }

    @Then("validate the checkout page displayed")
    public static void validateOrderSuccess() throws IOException {
        test = extent.createTest("Validate that the order is done successfully", "User validate message for order successfully done is displayed");
        boolean checkoutPage = ClickChoose_Locators.checkoutPage(driver).isDisplayed();
        if (checkoutPage) {
            test.log(Status.PASS, "Test Passed, Checkout page displayed successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Checkout page displayed failed");
            screenshotEvidence();
        }
        Assert.assertTrue(checkoutPage);
    }

}
