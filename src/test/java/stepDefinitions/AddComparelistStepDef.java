package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.*;
import static hooks.Hooks.test;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class AddComparelistStepDef {

    @When("click on specific categorise")
    public static void clickCategorise() {
        ClickChoose_Locators.chooseCategories(driver).click();
    }

    @And("click on specific product")
    public static void clickOnChosenProduct() {
        ClickChoose_Locators.chooseProductComparelist(driver).click();
    }

    @And("click on add to compare list icon to selected product")
    public static void clickAddComparelistProduct() throws InterruptedException {
        Thread.sleep(6000);
        ClickChoose_Locators.addToComparelist(driver).click();
    }

    @Then("validate product added to compare list")
    public static void validateProductInCompareList() throws IOException {
        test = extent.createTest("Validate product add to compare list", "User validate message for product add to compare list is displayed");
        boolean addCompareList = ClickChoose_Locators.productInCompareList(driver).getText().contains("The product has been added");
        if (addCompareList) {
            test.log(Status.PASS, "Test Passed, Product add to compare list successfully");
        } else {
            test.log(Status.FAIL, "Test Failed, Product add to compare list failed");
            screenshotEvidence();
        }
        Assert.assertTrue(addCompareList);
    }

}
