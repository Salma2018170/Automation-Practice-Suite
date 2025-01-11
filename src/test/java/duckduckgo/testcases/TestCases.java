package duckduckgo.testcases;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.DuckduckgoHomePage;
import web.pages.SearchPage;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestCases {
    //Driver initialization
    private WebDriver driver;
    //Pages initialization
    private DuckduckgoHomePage duckduckgoHomePage;
    private SearchPage searchPage;
//URL
    String url="https://duckduckgo.com/";
    //data
    String expectedTitle="Google";
    String expectedtSeleniumDevText="https://www.selenium.dev › documentation › webdriver";


    /**
     #1
     ________________ Basic ________________
     Open Google Chrome
     Navigate to [https://duckduckgo.com/]
     Assert that the page title is [Google]
     Close Google Chrome

     */
    @Description("Validate Google Title Task1")
    @Test
    public void validateGoogleTitle(){
    duckduckgoHomePage.assertOnGoogleTitle(expectedTitle);

    }

   /** #2
    ________________ Basic ________________
    Open Google Chrome
    Navigate to [https://duckduckgo.com/]
    Assert that the DuckDuckGo logo is displayed
    Close Google Chrome
    */
    @Description("Validate Duckduckgo Logo is displayed Task2")
    @Test
    public void validateDuckduckgoLogo(){
        duckduckgoHomePage.assertOnDuckduckgoPageLogo();

    }

    /**
      Open Google Chrome
     Navigate to [https://duckduckgo.com/]
     Search for [Selenium WebDriver]
     Assert that the link of the first result is [https://www.selenium.dev/documentation/webdriver/]
     Close Google Chrome

     */
    @Description("Search for Selenium WebDriver Task3")
    @Test
    public void searchForSelenium(){
        duckduckgoHomePage.setSearchBox("Selenium WebDriver");
        duckduckgoHomePage.clickOnSearchIcon();
        //need to wait for the search result to be displayed
        //Also we need to handle the wait in a better way
        //Need to handle data in a better way
        searchPage.assertOnSeleniumDevFirstLink(expectedtSeleniumDevText);


    }
    /** #4
    ________________ Moderate ________________
    Open Mozilla Firefox
    Navigate to [https://duckduckgo.com/]
    Search for [TestNG]
    Assert that the text of the fourth result is [TestNG Tutorial]
    Close Mozilla Firefox
     */

    @Description("Search for testNG Task4")
    @Test
    public void searchForTestNG(){
        duckduckgoHomePage.setSearchBox("TestNG");
        duckduckgoHomePage.clickOnSearchIcon();
        String expectedText=searchPage.getTextOfTheFourthResult();

        Assert.assertEquals(expectedText,"TestNG Tutorial");

    }


    @BeforeMethod
    public void  setup() {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
        //driver=new ChromeDriver();
        //driver.get("https://duckduckgo.com/");
        driver.navigate().to(url);
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Pages initialization
        duckduckgoHomePage =new DuckduckgoHomePage(driver);
        searchPage=new SearchPage(driver);

    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
