package Practice;

import ReusableLibraries.ReusableAnnotations;
import ReusableLibraries.ReusableMethodsLoggers;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.awt.SystemColor.desktop;

public class Mlcalc_DataDriven extends ReusableAnnotations {

    @Test
    public void getMonthlyPayment() throws BiffException, IOException, InterruptedException, WriteException {

        //get the file path of the workbook
        Workbook readFile = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_DataDriven.xls"));
        //make a copy of the read file so it doesn't get overwritten
        WritableWorkbook writeFile = Workbook.createWorkbook(new File("src/main/resources/Mlcalc_DataDriven_Write.xls"),readFile);
        //read the cells from writable work sheet
        WritableSheet workSheet = writeFile.getSheet(0);
        //get the physical count of the sheet
        int rowCount = workSheet.getRows();

        //set the for loop to iterate through the physical row count
        for(int i=1; i < rowCount; i++){
            //read the data for purchase price from the rows
            String pPrice = workSheet.getCell(0,i).getContents();
            //read the data for down payment from the rows
            String dPayment = workSheet.getCell(1,i).getContents();
            //read the data for mortgage term from the rows
            String mTerm = workSheet.getCell(2,i).getContents();
            //read the data for interest rate from the rows
            String intRate = workSheet.getCell(3,i).getContents();
            //read the data for start month from the rows
            String strMonth = workSheet.getCell(4,i).getContents();
            //read the data for start year from the rows
            String strYear = workSheet.getCell(5,i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            //clear and enter new purchase price
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='ma']",pPrice,logger,"Purchase Price");
            //clear and enter down payment
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='dp']",dPayment,logger,"Down Payment");
            //clear and enter mortgage term
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='mt']",mTerm,logger,"Mortgage Term");
            //clear and enter interest rate
            ReusableMethodsLoggers.sendKeysMethod(driver,"//*[@id='ir']",intRate,logger,"Interest Rate");
            //click on show advanced options
            ReusableMethodsLoggers.clickMethod(driver,"//*[text()='Show advanced options']",logger,"Show Advanced Options");
            //select start month
            ReusableMethodsLoggers.selectByVisibleText(driver,"//*[@name='sm']",strMonth,logger,"Start Month");
            //select start year
            ReusableMethodsLoggers.selectByVisibleText(driver,"//*[@name='sy']",strYear,logger,"Start Year");
            //click on calculate
            ReusableMethodsLoggers.clickMethod(driver,"//*[@value='Calculate']",logger,"Calculate");
            //capture monthly payment
            String mntPayment = ReusableMethodsLoggers.getTextMethod(driver,"(//*[@style='font-size: 32px'])[1]",logger,"Monthly Payment");
            //create a label on the monthly payment on which column and row you want to store it to
            Label label = new Label(6,i,mntPayment);
            //now add the label to the work sheet on writable workbook
            workSheet.addCell(label);
        }//end of loop
           //close read file
            readFile.close();
           //write to the writable file
            writeFile.write();
            writeFile.close();


            //open the writable excel file
            File file = new File("src/main/resources/Mlcalc_DataDriven_Write.xls");
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);

    }//end of test


}//end of test
