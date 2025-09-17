package web.pages.duckduckgo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import engine.WebElementActions;

import static org.testng.Assert.assertEquals;

public class SearchPage {
    //driver initialization
    WebDriver driver;
    //Locators initialization



    By seleniumDevLink = By.xpath("//a[@data-testid='result-extras-url-link' and @href='https://www.selenium.dev/documentation/webdriver/']");

    By fourthResultText=By.xpath("//li[@data-layout='organic'][4]//a[@data-testid='result-title-a']");
    int index=2;
    By secondResultText=By.xpath("//li[@data-layout='organic']["+index+"]//a[@data-testid='result-extras-url-link']");

    //constructor

    public SearchPage(WebDriver driver){
        this.driver=driver;
    }
    //Actions on the page


    //Validations on the page
    public  void assertOnSeleniumDevFirstLink(String expectedResult){
        System.out.println("The first link is: "+driver.findElement(seleniumDevLink).getText());
        assertEquals(WebElementActions.getElementText(driver,seleniumDevLink),expectedResult);
    }

    public  String getTextOfTheFourthResult ( ){
     return driver.findElement(fourthResultText).getText();
    }

    public  SearchPage assertOnCucumberTutorialSecondLink(String expectedResult){
        String actualResult=driver.findElement(secondResultText).getText();
        assertEquals(actualResult,expectedResult);
        return this;
    }


}
