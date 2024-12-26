package web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebElementActions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DuckduckgoHomePage {
    WebDriver driver;

    //loctoers
    By duckduckgoLogo = By.xpath("//div[contains(@class, 'headerWrapDesktop')]//a[@title='Learn about DuckDuckGo']");

    By searchBox = By.xpath("//input[contains(@id, 'searchbox_input')]");

    By searchButtonIcon = By.xpath("//button[contains(@class, 'searchbox_searchButton')]");
    public DuckduckgoHomePage(WebDriver driver){
        this.driver=driver;
    }

    public void searchOnDuckduckgo(String searchKey){
        WebElementActions.type(driver,searchBox,searchKey);
        WebElementActions.click(driver,searchButtonIcon);
    }

    public void assertOnGoogleTitle(String expectedTitle){
        assertEquals(WebElementActions.getTitle(driver),expectedTitle);
    }
    public void assertOnDuckduckgoPageLogo(){
        assertTrue(driver.findElement(duckduckgoLogo).isDisplayed());
    }
}
