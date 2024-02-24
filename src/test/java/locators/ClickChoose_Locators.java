package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickChoose_Locators {

    // Registration
    public static WebElement resister(WebDriver driver) {
        return driver.findElement(By.className("ico-register"));
    }

    public static WebElement gender(WebDriver driver) {
        return driver.findElement(By.id("gender-male"));
    }

    public static void dayDropDown(WebDriver driver) {
        WebElement dayDropDown = driver.findElement(By.name("DateOfBirthDay"));
        Select dayBirth = new Select(dayDropDown);
        dayBirth.selectByValue("2");
    }

    public static void monthDropDown(WebDriver driver) {
        WebElement monthDropDown = driver.findElement(By.name("DateOfBirthMonth"));
        Select monthBirth = new Select(monthDropDown);
        monthBirth.selectByValue("6");
    }

    public static void yearDropDown(WebDriver driver) {
        WebElement yearDropDown = driver.findElement(By.name("DateOfBirthYear"));
        Select yearBirth = new Select(yearDropDown);
        yearBirth.selectByValue("1994");
    }

    public static WebElement clickReg(WebDriver driver) {
        return driver.findElement(By.id("register-button"));
    }

    // Login
    public static WebElement login(WebDriver driver) {
        return driver.findElement(By.className("ico-login"));
    }

    public static WebElement clickLoginButton(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@class=\"button-1 login-button\"]"));
    }

    // Forget Password
    public static WebElement forgetPwd(WebDriver driver) {
        return driver.findElement(By.linkText("Forgot password?"));
    }

    public static WebElement recoverButton(WebDriver driver) {
        return driver.findElement(By.name("send-email"));
    }

    // Search for product
    public static WebElement searchField(WebDriver driver) {
        return driver.findElement(By.xpath("//*[@id=\"q\"]"));
    }

    public static WebElement searchFieldButton(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[1]/form/div[2]/button"));
    }

    public static WebElement productsListDisplayed(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div"));
    }

    public static WebElement searchSuccessfullyDone(WebDriver driver) {
        return driver.findElement(By.className("page-title"));
    }

    public static WebElement validateProductsNames(WebDriver driver) {
        return driver.findElement(By.cssSelector("h2[class='product-title']"));
    }

    // Switch between currencies US-Euro
    public static void selectCurrencyUS(WebDriver driver) {
        WebElement selectCurrencyUS = driver.findElement(By.id("customerCurrency"));
        Select chooseCurrencyUS = new Select(selectCurrencyUS);
        chooseCurrencyUS.selectByVisibleText("US Dollar");
    }

    public static void selectCurrencyEU(WebDriver driver) {
        WebElement selectCurrencyEU = driver.findElement(By.id("customerCurrency"));
        Select chooseCurrencyEU = new Select(selectCurrencyEU);
        chooseCurrencyEU.selectByVisibleText("Euro");
    }

    // Choose and click Categories
    public static WebElement chooseCategories(WebDriver driver) {
        return driver.findElement(By.linkText("Digital downloads"));
    }

    public static WebElement validateCategoriesDisplayed(WebDriver driver) {
        return driver.findElement(By.className("page-title"));
    }

    // Filter by color
    public static WebElement filterByColorGray(WebDriver driver) {
        return driver.findElement(By.id("attribute-option-14"));
    }

    public static void hoverClickShoesProduct(WebDriver driver) {
        Actions mouseHover = new Actions(driver);
        mouseHover.moveToElement(new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[3]/a[@href='/apparel']"))))).perform();
        new WebDriverWait(driver, Duration.ofMillis(6000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a[@href='/shoes']"))).click();
    }

    // Add to cart
    public static WebElement addToCart(WebDriver driver) {
        return driver.findElement(By.id("add-to-cart-button-35"));
    }

    public static WebElement productInCart(WebDriver driver) {
        return driver.findElement(By.cssSelector("p[class='content']"));
    }

    // Select different tag
    public static WebElement selectSpecTag(WebDriver driver) {
        return driver.findElement(By.linkText("awesome"));
    }

    public static WebElement categorySelection(WebDriver driver) {
        return driver.findElement(By.className("page-title"));
    }

    public static WebElement productList(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[class='item-grid']"));
    }

    // Add to wishlist
    public static WebElement chooseProductWishlist(WebDriver driver) {
        return driver.findElement(By.linkText("If You Wait (donation)"));
    }

    public static WebElement productInWishList(WebDriver driver) {
        return driver.findElement(By.cssSelector("p[class='content']"));
    }

    public static WebElement chooseProductAddCart(WebDriver driver) {
        return driver.findElement(By.linkText("If You Wait (donation)"));
    }

    public static WebElement chooseProductComparelist(WebDriver driver) {
        return driver.findElement(By.linkText("If You Wait (donation)"));
    }

    public static WebElement clickWishCatBut(WebDriver driver) {
        return driver.findElement(By.id("add-to-wishlist-button-35"));
    }


    // Add to compare
    public static WebElement addToComparelist(WebDriver driver) {
        return driver.findElement(By.xpath("//button[@class=\"button-2 add-to-compare-list-button\"]"));
    }

    public static WebElement productInCompareList(WebDriver driver) {
        return driver.findElement(By.cssSelector("p[class='content']"));
    }

    // Create successful Order
    public static WebElement clickShoppingCart(WebDriver driver) {
        return driver.findElement(By.className("cart-label"));
    }

    public static WebElement acceptTerms(WebDriver driver) {
        return driver.findElement(By.id("termsofservice"));
    }

    public static WebElement clickCheckOut(WebDriver driver) {
        return driver.findElement(By.id("checkout"));
    }

    public static void selectCountry(WebDriver driver) {
        WebElement selectCountry = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select chooseCurrencyEU = new Select(selectCountry);
        chooseCurrencyEU.selectByVisibleText("Egypt");
    }

    public static WebElement clickContinueBilling(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='button-1 new-address-next-step-button']"));
    }

    public static WebElement paymentMethodDisplayed(WebDriver driver) {
        return driver.findElement(By.id("opc-payment_method"));
    }

    // Payment options and confirm
    public static WebElement paymentOption(WebDriver driver) {
        return driver.findElement(By.id("paymentmethod_0"));
    }

    public static WebElement clickContinuePaymentOption(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='button-1 payment-method-next-step-button']"));
    }

    public static WebElement paymentConfirmationDisplayed(WebDriver driver) {
        return driver.findElement(By.id("opc-payment_info"));
    }

    public static WebElement clickContinuePaymentConfirmation(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='button-1 payment-info-next-step-button']"));
    }

    public static WebElement confirmOrderDisplayed(WebDriver driver) {
        return driver.findElement(By.id("checkout-step-confirm-order"));
    }

    // confirm checkout
    public static WebElement clickConfirmOrder(WebDriver driver) {
        return driver.findElement(By.cssSelector("button[class='button-1 confirm-order-next-step-button']"));
    }

    public static WebElement checkoutPage(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[class='page-title']"));
    }

    public static WebElement orderSuccessfully(WebDriver driver) {
        return driver.findElement(By.xpath(".//*[text()[contains(.,\"Your order has been successfully processed!\")]]"));
    }

    public static WebElement orderNumber(WebDriver driver) {
        return driver.findElement(By.cssSelector("div[class='order-number']"));
    }


}
