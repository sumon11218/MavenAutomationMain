package POM_Classes.Google_POM;

import ReusableLibraries.ReusableMethodsLoggers_POM;
import ReusableLibraries.TestParent;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestParent {

    /*
      Constructor method is a bridge between a page object class &
      test class. It allows you to initialize the WebDriver from your test parent & logger for example
      to interact with the web elements(xpaths) for each of the page object class you are creating
     */
    ExtentTest logger;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = TestParent.logger;
    }//end of constructor

    //store and define all of your xpath that you need from this page
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;

   //create a method for search field
   public void enterAKeyword(String userData){
       ReusableMethodsLoggers_POM.sendKeysMethod(driver,searchField,userData,logger,"Search Field");
   }//end of enterAKeyword

    //create a method for Google search submit button
    public void submitOnGoogleSearchButton(){
        ReusableMethodsLoggers_POM.submitMethod(driver,googleSearchButton,logger,"Google Search Button");
    }//end of submitOnGoogleSearchButton


}//end of class
