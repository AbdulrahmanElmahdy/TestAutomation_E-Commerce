package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import org.openqa.selenium.By;
import org.testng.Assert;

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

import java.io.IOException;

public class SelectCategStepDef {

    @Given("click on selected categorise")
    public static void clickCategorise() {
        ClickChoose_Locators.chooseCategories(driver).click();
    }

    @When("categorises page is displayed")
    public static void validateCategoriesDisplayed() {
        ClickChoose_Locators.validateCategoriesDisplayed(driver).isDisplayed();
    }

    @Then("selected categorise page will open")
    public static void validateSelectedCatPageOpen() throws IOException {
        test = extent.createTest("Validate selected category page is displayed", "User selected category is displayed");
        boolean result = driver.findElement(By.className("product-title")).getText().contentEquals("If You Wait (donation)");
        if (result) {
            test.log(Status.PASS, "Test Passed, Selected category successfully opened");
        } else {
            test.log(Status.FAIL, "Test Failed, Selected category opened failed");
            screenshotEvidence();
        }
        Assert.assertTrue(result);
    }
}
