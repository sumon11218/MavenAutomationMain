package POM_Scenarios;

import POM_Classes.Google_POM.BasePage;
import POM_Classes.Google_POM.HomePage;
import ReusableLibraries.TestParent;
import org.testng.annotations.Test;

public class GoogleSearch_POM_Test extends TestParent {

    @Test
    public void SearchForBMW() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        BasePage.homepage().enterAKeyword("BMW");
        BasePage.homepage().submitOnGoogleSearchButton();

    }//end of test 1

    @Test(dependsOnMethods = "SearchForBMW")
    public void getSearchNumber(){
        BasePage.searchResultPage().captureSearchNumber("BMW");
    }//end of test 2
}//end of class
