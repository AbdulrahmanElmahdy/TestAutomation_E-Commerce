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
import static hooks.Hooks.test;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class AddToCartStepDef {

    @Given("clicking on selected categorise")
    public static void clickCategorise() {
        ClickChoose_Locators.chooseCategories(driver).click();
    }

    @When("clicking on selected product")
    public static void clickOnSelectedProduct() {
        ClickChoose_Locators.chooseProductAddCart(driver).click();
    }

    @And("click on add to cart to selected product")
    public static void clickAddCartToProduct() throws InterruptedException {
        Thread.sleep(6000);
        ClickChoose_Locators.addToCart(driver).click();
    }

    @Then("validate product added to cart")
    public static void validateProductInCart() throws IOException {
        test = extent.createTest("Validate product add to cart", "User validate message for product add to cart is displayed");
        boolean addCart = ClickChoose_Locators.productInCart(driver).getText().contains("The product has been added");
        if (addCart) {
            test.log(Status.PASS, "Test Passed, Product add to cart successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Product add to cart failed");
            screenshotEvidence();
        }
        Assert.assertTrue(addCart);
    }
}
