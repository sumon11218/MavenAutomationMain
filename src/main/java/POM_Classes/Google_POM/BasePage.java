package POM_Classes.Google_POM;

import ReusableLibraries.TestParent;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends TestParent {
    /*
     Constructor method is a bridge between a page object class &
     test class. It allows you to initialize the WebDriver from your test parent & logger for example
     to interact with the web elements(xpaths) for each of the page object class you are creating
    */
    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor

    //create a static reference to your Google Home Page in order to use the methods in your test class
    //create static reference for google home page
    public static HomePage homepage(){
        HomePage homepage = new HomePage(driver);
        return  homepage;
    }//end of HomePage reference

    //create static reference for google search results page
    public static SearchResultPage searchResultPage(){
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        return  searchResultPage;
    }//end of SearchResultPage reference

}//end of class
