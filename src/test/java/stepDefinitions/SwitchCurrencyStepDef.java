package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ClickChoose_Locators;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static hooks.Hooks.driver;
import static hooks.Hooks.test;
import static screenshots.ScreenshotsEvidence.screenshotEvidence;

public class SwitchCurrencyStepDef {


    @Given("click on currency drop-list and choose Euro")
    public static void clickChooseCurrencyEU() {
        ClickChoose_Locators.selectCurrencyEU(driver);
    }

    @When("Euro selected, check euro sign")
    public void euroSelectedCheckEuroSign() throws IOException {
        boolean currencyEuroSign = driver.findElement(By.cssSelector("span[class='price actual-price']")).getText().contains("$");
        System.out.println(currencyEuroSign);
        if (currencyEuroSign) {
            test.log(Status.PASS, "Test Passed, search result contain the searched product");
        } else {
            test.log(Status.FAIL, "Test Failed, products doesn't exist");
            screenshotEvidence();
        }
        Assert.assertTrue(currencyEuroSign);
    }

    @And("click on currency drop-list and choose US Dollar")
    public static void clickChooseCurrencyUS() {
        ClickChoose_Locators.selectCurrencyUS(driver);
    }


    @Then("Dollar selected, check dollar sign")
    public void dollarSelectedCheckDollarSign() throws IOException {
        boolean currencyDollarSign = driver.findElement(By.cssSelector("span[class='price actual-price']")).getText().contains("€");
        System.out.println(currencyDollarSign);
        if (currencyDollarSign) {
            test.log(Status.PASS, "Test Passed, search result contain the searched product");
        } else {
            test.log(Status.FAIL, "Test Failed, products doesn't exist");
            screenshotEvidence();
        }
        Assert.assertTrue(currencyDollarSign);
    }
}
