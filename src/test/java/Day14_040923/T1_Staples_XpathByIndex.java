package Day14_040923;

import ReusableLibraries.ReusableAnnotations_CrossBrowser;
import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T1_Staples_XpathByIndex extends ReusableAnnotations_CrossBrowser {

    @Test(priority = 1)
    public void ClickOnThirdIphoneByXpathIndexInStaples() throws InterruptedException {
        logger.log(LogStatus.INFO,"Navigate to Staples home page");
        //navigate to staples home page
        driver.navigate().to("https://www.staples.com");

        //type on search field using sendkeys method
        ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='searchInput']","iphone",logger,"Search Field");

        //click on the search icon
        ReusableMethodsLoggers.clickMethod(driver,"//*[@class='search-bar-input__searchIcon']",logger,"Search Icon");

        //click on third image by xpath index
        //Thread.sleep(4000);
        ReusableMethodsLoggers.clickMethod(driver,"(//*[@class='standard-tile__image standard-tile__image_hover'])[3]",logger,"Iphone Image");

        //Thread.sleep(2000);

    }//end of test 1

}
