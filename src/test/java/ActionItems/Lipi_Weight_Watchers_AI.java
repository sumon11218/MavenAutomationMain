package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Lipi_Weight_Watchers_AI {
    public static void main(String[] args) throws InterruptedException {
        //create an array list with zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11425");
        zipCode.add("14223");
        zipCode.add("14227");

        WebDriverManager.chromedriver().setup();
        //declare the chrome options
        ChromeOptions options = new ChromeOptions();
        //add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //run in headless mode (runs in the background)
        // options.addArguments("headless");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        for (int i = 0; i< zipCode.size(); i++) {
            //navigate to weight watchers
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait two seconds
            Thread.sleep(1500);
            //click on find a workshop
            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
            Thread.sleep(1500);
            //click on in person link
            WebElement location = driver.findElement(By.xpath("//*[@id ='location-search']"));
            //clear the zipcode field
            location.clear();
            location.sendKeys("11425");
            location.submit();
            Thread.sleep(1500);
            //search for the studios;
            ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'linkUnderline')]")));
            System.out.println("Link count: " + studioLink.size());
            Thread.sleep(2000);
            if (i == 0) {
                studioLink.get(1).click();
            } else if (i == 1) {
                studioLink.get(2).click();
            } else if (i== 2) {
                studioLink.get(0).click();
            }//end of if else
            Thread.sleep(2000);
            String address = driver.findElement(By.xpath("//*[@class = 'address-2PZwW']")).getText();
            System.out.println("My address is " + address );
        }//end of loop

    }//end of main
}//end of class
