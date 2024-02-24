package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    public static ExtentTest test;
    public static ExtentReports extent = new ExtentReports();
    public static ExtentSparkReporter spark;

    @Before
    public static void browserLaunching() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    @After
    public static void tearDown() {
        extent.flush();
        driver.quit();
    }
}
