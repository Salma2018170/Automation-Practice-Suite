package web.pages.duckduckgo;

import engine.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DuckduckgoHomePage {
    WebDriver driver;
    private ActionBot actionBot;
    // URL

    private String url="https://duckduckgo.com/";

    //loctoers
    By duckduckgoLogo = By.xpath("//div[contains(@class, 'headerWrapDesktop')]//a[@title='Learn about DuckDuckGo']");

    By searchBox = By.xpath("//input[contains(@id, 'searchbox_input')]");

    By searchButtonIcon = By.xpath("//button[contains(@class, 'searchbox_searchButton')]");

    By testNGTutorialText = By.xpath("//span[contains(@class, 'searchbox_suggestionText') and span[normalize-space()='tutorial'] and span[text()='testng']]");

    int index=2;
    By secondResultText=By.xpath("//li[@data-layout='organic']["+index+"]//a[@data-testid='result-extras-url-link']");

    //constructor
    public DuckduckgoHomePage(WebDriver driver){
        this.driver=driver;

    }
    //Actions on the page

    public DuckduckgoHomePage navigateToDuckduckgoHomePage(){
        driver.navigate().to(url);
        return this;
    }
    public DuckduckgoHomePage setSearchBox(String searchKey){
        actionBot.type(searchBox,searchKey);
      //  ActionBot.click(driver,searchButtonIcon);
        return this;
    }
    public SearchPage clickOnSearchIcon(){
        actionBot.click(searchButtonIcon);
        return new SearchPage(driver);
    }
//Validations on the page
    public void assertOnGoogleTitle(String expectedTitle){
        assertEquals(ActionBot.getTitle(driver),expectedTitle);
    }
    public void assertOnDuckduckgoPageLogo(){

        assertTrue(driver.findElement(duckduckgoLogo).isDisplayed());
    }

    public  void assertOnTestNGTutorial(String expectedResult){
        System.out.println("The fourth link is: "+driver.findElement(testNGTutorialText).getText());
        //assertEquals(ActionBot.getElementText(driver,testNGTutorialText),expectedResult);
    }

}
