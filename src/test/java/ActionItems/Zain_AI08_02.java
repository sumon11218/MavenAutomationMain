package ActionItems;

import ReusableLibraries.TestParent;
import ReusableLibraries.ReusableMethodsLoggers;
import org.testng.annotations.Test;

public class Zain_AI08_02 extends TestParent {

    @Test
    public void tc001_searchForBoatsLoans(){
        //navigate to truist home page
        driver.navigate().to("https://www.truist.com/");
        //Click on loans dropdown
        ReusableMethodsLoggers.clickMethod(driver, "//*[text() = 'Loans']", logger, "loansDropdown");
        //click on boats & RV loans offers
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class =  'dropdown-item loans-dropdown']", 7, logger, "Boats and RV loans Offer");
        //click on Apply in person
        ReusableMethodsLoggers.clickMethod(driver,"//*[@data-wa-linkname='Apply in person']", logger, "Apply In Person Button");
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_searchForBoatsLoans")
    public void tc002_FindABranch() throws InterruptedException {
        Thread.sleep(3000);
        //click on clear search button
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class = 'locator-search-close-icon']", logger, "Clear previous address");
        //enter address in the field
        ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@id= 'autocomplete']", "Cincinnati, OH, USA", logger, "Address Field");
        //click on search button
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class= 'btn google-search-button']", logger, "Click Search BUtton");
        //click on no thanks
        ReusableMethodsLoggers.clickMethod(driver, "//*[@aria-label='No thanks']", logger, "Popup");
        //click on first branch
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class='js-detail-link']", 0, logger, "Click on first branch");
        //capture and print branch name
        String branchName = ReusableMethodsLoggers.getTextMethod(driver, "//*[@class='branch-heading']", logger, "Branch Name");
        System.out.println("The branch name is " + branchName);
        //capture and print branch information
        String branchInfo = ReusableMethodsLoggers.getTextMethod(driver, "//*[@class='locator-image-content']", logger, "Brach Address");
        System.out.println("The branch information is " + branchInfo);
        //click on make an appointment
        ReusableMethodsLoggers.clickMethod(driver, "//*[@id='make-apt']", logger, "Click on appointment Button");

    }//end of test case 2

    @Test(dependsOnMethods ="tc002_FindABranch")
    public void tc003_MakeAnAppointment() {
        //switch tab to make an appointment tab
        ReusableMethodsLoggers.switchTabsByIndexMethod(driver, 1, "Appointment Tab");
        //click on loan check box
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class ='slds-checkbox_faux']", 2, logger, "Loan CheckBox");
        //click on next
        ReusableMethodsLoggers.clickMethod(driver, "//*[@class='slds-button slds-button_brand']", logger, "Click Next");
        //enter zipcode
        ReusableMethodsLoggers.sendKeysMethod(driver, "//*[@role='combobox']","Cincinnati, OH 45242, USA", logger, "Enter ZipCode");
        //select first location
        ReusableMethodsLoggers.clickMethodByIndex(driver, "//*[@class='optionText']", 0, logger, "Select first location");
        //Capture and print first location informatiom
        String location = ReusableMethodsLoggers.getTextMethod(driver, "//*[@class='slds-grid slds-gutters']", logger, "Location Information");
        System.out.println("The nearby Branch Information is " + location);
        //close the tab
        driver.close();
    }//end of test case 3



}//end of class
