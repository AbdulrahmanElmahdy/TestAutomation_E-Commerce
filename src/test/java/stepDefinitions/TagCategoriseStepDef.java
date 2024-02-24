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

public class TagCategoriseStepDef {

    @Given("click on selected categorise \"Digital downloads\"")
    public static void clickSelectedCategorise() {
        ClickChoose_Locators.chooseCategories(driver).click();
    }

    @When("digital downloads is displayed")
    public void digitalDownloadsIsDisplayed() throws IOException {
        test = extent.createTest("Validate selected category page is displayed", "User selected category is displayed");
        boolean selectedCategory = ClickChoose_Locators.categorySelection(driver).getText().contentEquals("Digital downloads");
        if (selectedCategory) {
            test.log(Status.PASS, "Test Passed, Selected category successfully opened");
        } else {
            test.log(Status.FAIL, "Test Failed, Selected category opened failed");
            screenshotEvidence();
        }
        Assert.assertTrue(selectedCategory);
    }

    @And("click on \"awesome\" tag")
    public static void clickOnSpecificTag() {
        ClickChoose_Locators.selectSpecTag(driver).click();
    }


    @Then("products with tag awesome are displayed")
    public void productsWithTagAwesomeAreDisplayed() throws IOException {
        test = extent.createTest("Validate product with selected tag are displayed", "User selected tag products are displayed");
        boolean selectedCategory = ClickChoose_Locators.categorySelection(driver).getText().contentEquals("Products tagged with 'awesome'");
        boolean productsList = ClickChoose_Locators.productList(driver).isDisplayed();
        if (selectedCategory && productsList) {
            test.log(Status.PASS, "Test Passed, Selected tag products successfully displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Selected tag products displayed failed");
            screenshotEvidence();
        }
        Assert.assertTrue(selectedCategory);
        Assert.assertTrue(productsList);
    }
}
