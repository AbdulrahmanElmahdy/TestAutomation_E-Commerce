package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InsertData_Locators {

    // Registation
    public static WebElement insertFrstName(WebDriver driver) {
        return driver.findElement(By.id("FirstName"));
    }

    public static WebElement insertLasName(WebDriver driver) {
        return driver.findElement(By.id("LastName"));
    }

    public static WebElement email(WebDriver driver) {
        return driver.findElement(By.id("Email"));
    }

    public static WebElement insertPwd(WebDriver driver) {
        return driver.findElement(By.id("Password"));
    }

    public static WebElement insertPwdConf(WebDriver driver) {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public static WebElement confirmationMessage(WebDriver driver) {
        return driver.findElement(By.className("result"));
    }

    // Login
    public static WebElement loginEmailinst(WebDriver driver) {
        return driver.findElement(By.id("Email"));
    }

    public static WebElement loginPwdinst(WebDriver driver) {
        return driver.findElement(By.id("Password"));
    }

    // Forget password
    public static WebElement emailForgetPwd(WebDriver driver) {
        return driver.findElement(By.id("Email"));
    }

    // Search for product
    public static WebElement searchForProduct(WebDriver driver) {
        return driver.findElement(By.id("small-searchterms"));
    }

    public static WebElement loginValidation(WebDriver driver) {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }

    public static WebElement validateFirstName(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='BillingNewAddress_FirstName']"));
    }

    public static WebElement validateLastName(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='BillingNewAddress_LastName']"));
    }

    public static WebElement validateEmail(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='BillingNewAddress_Email']"));
    }

    public static WebElement firstNameBilling(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='BillingNewAddress_FirstName']"));
    }

    public static WebElement lastNameBilling(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='BillingNewAddress_LastName']"));
    }

    public static WebElement emailBilling(WebDriver driver) {
        return driver.findElement(By.cssSelector("input[id='BillingNewAddress_Email']"));
    }

    public static WebElement insertCity(WebDriver driver) {
        return driver.findElement(By.id("BillingNewAddress_City"));
    }

    public static WebElement insertAddress(WebDriver driver) {
        return driver.findElement(By.id("BillingNewAddress_Address1"));
    }

    public static WebElement insertPostalCode(WebDriver driver) {
        return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    }

    public static WebElement insertPhoneNumber(WebDriver driver) {
        return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    }

}
