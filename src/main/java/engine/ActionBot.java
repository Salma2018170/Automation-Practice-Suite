package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionBot {
    private  final WebDriver driver;

    // Constructor
    public ActionBot(WebDriver driver) {
        this.driver=driver;

    }

    //Get the title of the page
    public static String getTitle(WebDriver driver) {

        return driver.getTitle();
    }
    //Get the text of the element
    public static String getElementText(WebDriver driver, By elementLocator) {
        return driver.findElement(elementLocator).getText();
    }
    public static void type(WebDriver driver, By elementLocator, String SearchKey) {
         driver.findElement(elementLocator).sendKeys(SearchKey);
    }
    public static void click(WebDriver driver , By elementLocator) {
        driver.findElement(elementLocator).click();

    }


}
