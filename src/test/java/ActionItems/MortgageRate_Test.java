package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MortgageRate_Test {

    WebDriver driver;
    @BeforeMethod
    public void setDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://54.237.88.48:4444/wd/hub"),cap);
    }
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
