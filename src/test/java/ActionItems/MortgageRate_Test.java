package ActionItems;

import ReusableLibraries.ReusableAnnotations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MortgageRate_Test extends ReusableAnnotations {

    @Test
    public void mortageRate() throws InterruptedException {
        //navigate to mortgage calc
        driver.navigate().to("https://www.bankrate.com/mortgages/mortgage-calculator/");
        Thread.sleep(2000);
        //clear and enter home price on the option
        WebElement homePrice = driver.findElement(By.xpath("//*[@id='homePrice']"));
        homePrice.clear();
        homePrice.sendKeys("600000");
        //clear and enter down payment
        WebElement downPayment = driver.findElement(By.xpath("//*[@aria-labelledby='down-payment']"));
        downPayment.clear();
        downPayment.sendKeys("120000");
        //clear and enter zip code
        WebElement zipCode = driver.findElement(By.xpath("//*[@data-test='zipcode']"));
        zipCode.clear();
        zipCode.sendKeys("11219");
        //clear and enter property tax
        WebElement propertyTax = driver.findElements(By.xpath("//*[@class='FormInput h-auto']")).get(1);
        propertyTax.clear();
        propertyTax.sendKeys("1500");

        //scroll down
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,500);");

        Thread.sleep(5000);
    }//end o test
}//end of class
