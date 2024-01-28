package ActionItems;

import ReusableLibraries.TestParent;
import ReusableLibraries.ReusableMethodsLoggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;

public class Upload_FedEx extends TestParent {
    @Test
    public void test() throws InterruptedException, AWTException {

        driver.navigate().to("https://www.fedex.com/en-us");
        ReusableMethodsLoggers.clickMethod(driver,"//*[@aria-label='Open Design & Print menu']",logger, "Design & Print ");
        ReusableMethodsLoggers.clickMethod(driver,"//*[contains(text(),'Explore Print, Products & Design')]",logger, "Explore Print, Products & Design");
        ReusableMethodsLoggers.clickMethod(driver,"//*[contains(text(),'Copies and Custom Documents')]",logger, "Copies and Custom Documents");
        ReusableMethodsLoggers.clickMethod(driver,"//*[@id='upload-a-file-button']",logger, "Upload a file Button");
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//*[@aria-label='Configurator iFrame']"));
        driver.switchTo().frame(element);
        //ReusableMethodsLoggers.clickMethod(driver,"//label[@for='edl-file-upload-1']",logger, "Browse Files Button");
        ReusableMethodsLoggers.sendKeysMethod(driver,"//input[@id='edl-file-upload-1']","/Users/sumonkashem/Documents/envelope.pptx",logger,"Upload File");
        ReusableMethodsLoggers.clickMethodByIndex(driver,"//*[@class='card-body']",1, logger, "Layout Type");
        ReusableMethodsLoggers.clickMethod(driver,"//button[text()='Next']",logger, "Next Button");

        Thread.sleep(20000);

    }//end of test
}//end of class
