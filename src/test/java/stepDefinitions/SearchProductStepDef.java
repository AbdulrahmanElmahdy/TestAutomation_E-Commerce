package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import locators.InsertData_Locators;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class SearchProductStepDef {

    @Given("write product in search box and click enter")
    public static void writeSearchProductName() {
        InsertData_Locators.searchForProduct(driver).sendKeys("Apple");
        InsertData_Locators.searchForProduct(driver).sendKeys(Keys.ENTER);
    }

    @When("search successfully done")
    public static void validateSearchSuccess() {
        if (ClickChoose_Locators.searchField(driver) == null) {
            writeSearchProductName();
            ClickChoose_Locators.searchFieldButton(driver).click();
        }
        ClickChoose_Locators.searchSuccessfullyDone(driver).isDisplayed();
    }

    @And("search page is opened")
    public static void validateProductsListDisplayed() {
        ClickChoose_Locators.productsListDisplayed(driver).isDisplayed();
    }

    @Then("check that searched product is displayed")
    public static void productsRelatedToSearchedWord() throws IOException {
        test = extent.createTest("Validate products of contain same searched word is displayed", "User validate the products contain searched word is displayed");
        boolean productNames = ClickChoose_Locators.validateProductsNames(driver).getText().contains("Apple");
        System.out.println(productNames);
        if (productNames) {
            test.log(Status.PASS, "Test Passed, search result contain the searched product");
        } else {
            test.log(Status.FAIL, "Test Failed, products doesn't exist");
            screenshotEvidence();
        }
        System.out.println(productNames);
        Assert.assertTrue(productNames);
    }

}
