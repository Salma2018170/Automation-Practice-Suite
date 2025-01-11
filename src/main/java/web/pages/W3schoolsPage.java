package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class W3schoolsPage {
    // Driver initialization

    private WebDriver driver;
    // Waiting
    private final Duration DURATION = Duration.ofSeconds(20);

    //Wait initialization
    private Wait<WebDriver> wait;

    // Locator

    //option1 //tr[contains(.,'Ernst Handel')]/td[3] == //tr[td[text()='Ernst Handel']]/td[3]

    /* option2 siblings implement
    //td[text()='Ernst Handel']/following-sibling::td[2]
     */

    /* option3
    //td[text()='Ernst Handel']/parent::tr/td[3]
    */
    By countryInTheTableText=By.xpath("//tr[contains(.,'Ernst Handel')]/td[3]");
    // Constructor
    public W3schoolsPage(WebDriver driver){
           this.driver=driver;
    }

    //Actions (Methods)
    public String getCountryName(){
        wait = new WebDriverWait(driver,DURATION);
        wait.until(d -> driver.findElement(countryInTheTableText));
      return driver.findElement(countryInTheTableText).getText();
    }
}
