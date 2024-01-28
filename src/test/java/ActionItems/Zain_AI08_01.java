package ActionItems;

import ReusableLibraries.TestParent;
import ReusableLibraries.ReusableMethodsLoggers;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Zain_AI08_01 extends TestParent {

    @Test
    public void tc001_searchForLoans() {
        //navigate to truist home page
        driver.navigate().to("https://www.truist.com/");
        //Click on loans dropdown
        ReusableMethodsLoggers.clickMethod(driver, "//*[text() = 'Loans']", logger, "loansDropdown");
        //click on loans offer
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class =  'dropdown-item loans-dropdown']", 0, logger, "loansOffer");
        //click on personal loan
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class = 'nav-item subpage-nav-item']", logger, "personalLoan");
        //click on apply now button
        ReusableMethodsLoggers.clickMethod(driver, "//*[@data-wa-linkname='Apply now']", logger, "applyNowButton");
    }//end of test case 1

    @Test
    public void tc002_applyForLoan() {
        //switch to personal loan application page
        ReusableMethodsLoggers.switchTabsByIndexMethod(driver,1, "personalLoanApplication");
        //capture things to know before starting an application
        String thingsToKnow = ReusableMethodsLoggers.getTextMethod(driver, "//*[@id='grid-6']", logger, "Things to Know");
        logger.log(LogStatus.INFO,"Before applying " + thingsToKnow);
        System.out.println("Before applying " + thingsToKnow);
        //click on start application button
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class = 'tru-core-margin-right--xs tru-core-button-wrapper']", logger,"Start Application Button");
        //select state
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class='tru-core-input__input-wrapper']",0 , logger,"state dropdown");
        ReusableMethodsLoggers.clickMethod(driver, "//*[text() = 'Florida']", logger, "Select State");
        //select citizenship status
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class='tru-core-input__input-wrapper']",1 , logger,"state dropdown");
        ReusableMethodsLoggers.clickMethod(driver, "//*[text() = 'US Citizen']", logger, "Citizenship");
        //click on no for existing customer
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id = 'tru-core-radio-button-input-2']", logger, "Not an Existing Customer");
        //click on start application button for submit
        ReusableMethodsLoggers.clickMethod(driver, "//*[@type = 'submit']", logger, "Click to start application");
        //close the current tab
        driver.close();
    }//end of test case 2

    @Test
    public void tc003_resumeApplication() {
        //switch to default tab
        ReusableMethodsLoggers.switchTabsByIndexMethod(driver,0, "personal Loan Page");
        //click on no thanks button on pop-up
        ReusableMethodsLoggers.clickMethod(driver, "//*[@aria-label='No thanks']", logger, "Pop-up");
        //click on apply now
        ReusableMethodsLoggers.clickMethod(driver, "//*[@data-wa-linkname='Apply now']", logger, "applyNowButton");
        //switch tab
        ReusableMethodsLoggers.switchTabsByIndexMethod(driver,1, "Resume application page");
        //click on resume button
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class = 'tru-core-margin-left--xs tru-core-button-wrapper']",logger, "Resume Button");
        //click on can't find application ID
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class = 'tru-core-link tru-core-link-text']", logger, "Can't Find ID button");
        //enter first name
        ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@aria-labelledby='firstName']", "Jon", logger, "First Name Field");
        //enter last name
        ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@aria-label='Last Name']", "Sean", logger, "Last Name Field");
        //enter last four of SSN
        ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@aria-labelledby='Social Security Number']", "0000", logger, "SSN Field");
        //close the current tab
        driver.close();

    }//end of test case 3



}//end of class
