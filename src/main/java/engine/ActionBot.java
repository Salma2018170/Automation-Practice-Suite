package engine;

import com.google.errorprone.annotations.Var;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ActionBot {
    // Driver initialization
    private  final WebDriver driver;

    //
    //
    Logger logger = LogManager.getLogger(getClass());
    // Constructor

    public ActionBot() throws MalformedURLException, URISyntaxException {
       ConfigReader.loadProperties();
       this.driver= WebBrowserFactory.getDriver();
        logger.info("Driver initialized");
    }

    //Get the title of the page
    @Step("Getting the title of the page")
    public static String getTitle(WebDriver driver) {

        return driver.getTitle();
    }
    //Get the text of the element
    public static String getElementText(WebDriver driver, By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }
    @Step("Typing {SearchKey} into element located by {elementLocator}")
    public ActionBot type(By elementLocator, String SearchKey) {
         driver.findElement(elementLocator).clear();
         driver.findElement(elementLocator).sendKeys(SearchKey);
         return this;
    }
    @Step("Clicking on element located by {elementLocator}")
    public ActionBot click(By elementLocator) {
        driver.findElement(elementLocator).click();
        return this;
    }
    @Step("Navigating to {URL}")
    public ActionBot navigateTo(String URL){
        driver.navigate().to(URL);
        return this;
    }
    public String getDomProperty(By elementLocator, String attributeName){
       var actualValue= this.driver.findElement(elementLocator).getDomProperty(attributeName);
        return actualValue;
    }
    @Step("Quiting the browser")
    public ActionBot quit(){
        if (driver!=null){
            driver.quit();
            logger.info("Driver quit successfully");
        }
       // logger.error("Driver is null, cannot quit");
        return this;
    }

}
