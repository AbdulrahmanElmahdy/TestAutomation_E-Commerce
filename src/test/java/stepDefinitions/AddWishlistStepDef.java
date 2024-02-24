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

public class AddWishlistStepDef {

    @Given("click on chosen categorise")
    public static void clickCategorise() {
        ClickChoose_Locators.chooseCategories(driver).click();
    }

    @When("click on chosen product")
    public static void clickOnChosenProduct() {
        ClickChoose_Locators.chooseProductWishlist(driver).click();
    }

    @And("click on add to wishlist icon to selected product")
    public static void clickAddWishlistProduct() throws InterruptedException {
        Thread.sleep(6000);
        ClickChoose_Locators.clickWishCatBut(driver).click();
    }

    @Then("validate product added to wishlist")
    public static void validateProductInWishList() throws IOException {
        test = extent.createTest("Validate product add to wishlist", "User validate message for product add to wishlist is displayed");
        boolean addWishlist = ClickChoose_Locators.productInWishList(driver).getText().contains("The product has been added");
        if (addWishlist) {
            test.log(Status.PASS, "Test Passed, Product add to wishlist successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Product add to wishlist failed");
            screenshotEvidence();
        }
        Assert.assertTrue(addWishlist);
    }
}
