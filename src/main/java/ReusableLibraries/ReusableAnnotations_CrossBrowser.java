package ReusableLibraries;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class ReusableAnnotations_CrossBrowser {

    //you need to make your WebDriver driver variable static since we are calling it to our test class
    public static WebDriver driver;
    //declare the report variable here
    public static ExtentReports reports;
    //declare logger variable here
    public static ExtentTest logger;

    //set before suite annotation method
    @BeforeSuite
    public void setDriver() {
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html", true);
    }//end of before suite

    //call before method annotation to capture each test name dynamically and cross browser(s)
    @BeforeMethod
    @Parameters("browser")
    public void getTestName(Method testName, String browser){
        logger = reports.startTest(testName.getName() + "_"+browser);
        switch (browser){
            case "chrome" :
                driver = ReusableMethodsLoggers.defineChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.manage().window().maximize();
                break;
        }//end of switch case statements
    }//end of before method

    @AfterMethod
    public void endSession(){
        //quit driver
        driver.quit();
        //end all logger
        reports.endTest(logger);
    }


    @AfterSuite
    public void quitDriver() {
        //write all the logs back to the html report including the test name
        reports.flush();
    }//end of after suite

}//end of class

