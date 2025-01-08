package testPakage;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.DuckduckgoHomePage;
import web.pages.SearchPage;

import static java.lang.Thread.sleep;

public class TestCases {
    //Driver initialization
    private WebDriver driver;
    //Pages initialization
    private DuckduckgoHomePage duckduckgoHomePage;
    private SearchPage searchPage;
//URL
    String url="https://www.w3schools.com/html/html_tables.asp";
    //data
    String expectedTitle="Google";
    String expectedtSeleniumDevText="https://www.selenium.dev › documentation › webdriver";
    @BeforeMethod
    public void  setup() {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
        //driver=new ChromeDriver();
        //driver.get("https://duckduckgo.com/");
        driver.navigate().to(url);

        //Pages initialization
        duckduckgoHomePage =new DuckduckgoHomePage(driver);
        searchPage=new SearchPage(driver);

    }

    @Description ("trying browser factory")
    @Test
    public void test1(){
        System.out.println("Test1");
    }
    @Description("Validate Google Title Task1")
    @Test
    public void validateGoogleTitle(){
    duckduckgoHomePage.assertOnGoogleTitle(expectedTitle);

    }
    @Description("Validate Duckduckgo Logo is displayed Task2")
    @Test
    public void validateDuckduckgoLogo(){
        duckduckgoHomePage.assertOnDuckduckgoPageLogo();

    }
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

    @Description("Search for testNG Task4")
    @Test
    public void searchForTestNG(){
        duckduckgoHomePage.setSearchBox("TestNG");
        duckduckgoHomePage.assertOnTestNGTutorial("TestNG ");

    }
//    Open Google Chrome
//    Navigate to [https://www.w3schools.com/html/html_tables.asp]
//    Assert that the Country for the Company [Ernst Handel] is [Austria]
//    Close Google Chrome

    @Description("assert for company Task7")
    @Test
    public void assertForTheCountryTask7(){
   ///Page loadstratiges

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
