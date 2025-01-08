package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

import static org.testng.Assert.assertEquals;

public class SearchPage {
    //driver initialization
    WebDriver driver;
    //Locators initialization


    //span[contains(@class, 'searchbox_suggestionText')]/span[.=" tutorial"]/span

    By seleniumDevLink = By.xpath("//a[@data-testid='result-extras-url-link' and @href='https://www.selenium.dev/documentation/webdriver/']");

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


}
