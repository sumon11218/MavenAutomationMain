package Day14_040923;

import ReusableLibraries.ReusableAnnotations_CrossBrowser;
import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.table.JTableHeader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class T2_Google_Test extends ReusableAnnotations_CrossBrowser{
    @Test(priority = 1)
    public void CaptureGoogleSearchNumberForCricket() throws InterruptedException {
        logger = reports.startTest("Google_Search");
        //navigate to google home
        logger.log(LogStatus.INFO,"Navigate to Google Home page");
        Thread.sleep(8000);
        ArrayList<String>cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Audi");
        cars.add("Lexus");
        cars.add("Acura");
        for (int i=0 ; i < cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //type the word cricket on search field
            ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@name='q']", cars.get(i), logger, "Search Field");
            //hit submit on google search
            ReusableMethodsLoggers.submitMethod(driver, "//*[@name='btnK']", logger, "Google Search Button");
            //capture the search result
            String result = ReusableMethodsLoggers.getTextMethod(driver, "//*[@id='result-stats']", logger, "Search Results");
            logger.log(LogStatus.INFO, "Search Results: " + result);
            String[] arrayResult = result.split(" ");
            System.out.println("Search number for cricket: " + arrayResult[1]);
            logger.log(LogStatus.INFO, "Search number for cricket: " + arrayResult[1]);
        }//end of loop
    }//end of test

    @AfterMethod
    public void endLogger(){
        reports.endTest(logger);
        reports.flush();
    }

}
