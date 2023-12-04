package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class ReusableAnnotations {

    //you need to make your WebDriver driver variable static since we are calling it to our test class
    public static WebDriver driver;
    //declare the report variable here
    public static ExtentReports reports;
    //declare logger variable here
    public static ExtentTest logger;

    //set before suite annotation method
    @BeforeSuite
    public void setDriver() {
        driver = ReusableMethods.defineChromeDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html", true);
    }//end of before suite

    //call before method annotation to capture each test name dynamically
    @Parameters("browser")
    @BeforeMethod
    public void getTestName(Method testName, String browser){
        logger = reports.startTest(testName.getName());
        if(browser == "chrome"){
            WebDriverManager.chromedriver().setup();
            //set up your chrome options arguments for your web driver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("incognito");
            //options.addArguments("headless");
            //set up option variable inside chrome driver for it to recognize your conditions
            driver = new ChromeDriver(options);
        } else if(browser == "firefox"){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }//end of before method


    @AfterSuite
    public void quitDriver() {
        //quit driver
        driver.quit();
        //end all logger
        reports.endTest(logger);
        //write all the logs back to the html report including the test name
        reports.flush();
    }//end of after suite

}//end of class

