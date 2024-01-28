package ActionItems;

import ReusableLibraries.TestParent;
import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;

public class USPS_Business extends TestParent {
    @Test
    public void test() throws InterruptedException, AWTException {
        driver.navigate().to("https://www.usps.com");
        ReusableMethodsLoggers.hoverMethod(driver,"//*[text()='Business']",logger, "Business Menu");
        ReusableMethodsLoggers.clickMethod(driver,"//*[text()='Calculate a Business Price']",logger, "Calculate a Business Price");
        sendkeysByJse(driver,"//*[@id='ShippingDate']","12/28/2023",logger,"Shipping Date");
        ReusableMethodsLoggers.clickMethod(driver,"//*[@value='Postcards']",logger, "Postcards");
        Thread.sleep(4000);
        String newMailLinkHref = driver.findElements(By.xpath("//*[text()='New Mailing']")).get(0).getAttribute("href");
        System.out.println("href: " + newMailLinkHref);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ReusableMethodsLoggers.switchTabsByIndexMethod(driver,1,"Tab 2");
        driver.navigate().to(newMailLinkHref);
        //driver.findElements(By.xpath("//*[text()='New Mailing']")).get(0).sendKeys(selectLinkOpeninNewTab);
        Thread.sleep(8000);
    }//end of test

    public static void sendkeysByJse(WebDriver driver, String xpath, String userValue, ExtentTest logger, String elementName) {
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].value='"+userValue+"';", element);
            System.out.println("Successfully scrolled into view " + elementName);
            logger.log(LogStatus.PASS, "Successfully entered value using JSE on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into view " + elementName + ": " + e);
            logger.log(LogStatus.FAIL, "Unable to enter value using JSE on " + elementName + ": " + e);
            ReusableMethodsLoggers.getScreenShot(driver, elementName, logger);
        }//end of exception
    }//end of scroll into view sendkeysByJse
}//end of class


