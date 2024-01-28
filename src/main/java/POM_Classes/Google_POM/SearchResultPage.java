package POM_Classes.Google_POM;

import ReusableLibraries.ReusableMethodsLoggers_POM;
import ReusableLibraries.TestParent;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends TestParent {

    ExtentTest logger;
    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = TestParent.logger;
    }//end of constructor

    //store and define all of your xpath that you need from this page
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResultText;

    public void captureSearchNumber(String keyValue){
        String results = ReusableMethodsLoggers_POM.getTextMethod(driver,searchResultText,logger,"Search Results");
        String[] arrayResults = results.split(" ");
        System.out.println("The search number for " + keyValue + " is " + arrayResults[1]);
        logger.log(LogStatus.INFO,"The search number for " + keyValue + " is " + arrayResults[1]);
    }//end of captureSearchNumber

}//end of class
