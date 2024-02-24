package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.*;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class FilterByColorStepDef {

    @Given("hover on Apparel and click on Shoes")
    public static void clickCategorise() {
        ClickChoose_Locators.hoverClickShoesProduct(driver);
    }

    @When("filter by color")
    public static void filterByColor() throws InterruptedException {
        Thread.sleep(4000);
        ClickChoose_Locators.filterByColorGray(driver).click();
    }

    @Then("check shoes filter is success")
    public static void validateFilterSuccess() throws IOException {
        test = extent.createTest("Validate color filter is successfully", "User products with filtered color is displayed");
        boolean imageDisplayed = driver.findElement(By.cssSelector("img[src='https://demo.nopcommerce.com/images/thumbs/0000051_nike-floral-roshe-customized-running-shoes_415.jpg']")).isDisplayed();
        if (imageDisplayed) {
            test.log(Status.PASS, "Test Passed, Products with same filtered color is displayed");
        } else {
            test.log(Status.FAIL, "Test Failed, Products with same filtered color is not displayed");
            screenshotEvidence();
        }
        Assert.assertTrue(imageDisplayed);
    }
}
