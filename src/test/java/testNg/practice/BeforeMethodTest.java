package testNg.practice;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import engine.ConfigReader;
import engine.WebBrowserFactory;
import web.pages.duckduckgo.DuckduckgoHomePage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BeforeMethodTest {
    //Driver initialization
    WebDriver driver;
    // Pages initialization
    DuckduckgoHomePage duckduckgoHomePage;
    @BeforeMethod
    public void  setup() throws MalformedURLException, URISyntaxException {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();

        driver.navigate().to("https://duckduckgo.com/");

        //Pages initialization
        duckduckgoHomePage =new DuckduckgoHomePage(driver);
    }


    @Description("Validate Google Title Task1")
    @Test
    public void validateGoogleTitle(){
        duckduckgoHomePage.assertOnGoogleTitle("Google");

    }
    @Description("Validate Google Title Task1 try")
    @Test
    public void validateGoogleTitle1(){
        duckduckgoHomePage.assertOnGoogleTitle("Google");

    }
    @AfterMethod
    public void  tearDown() throws MalformedURLException, URISyntaxException {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
        //driver=new ChromeDriver();
        //driver.get("https://duckduckgo.com/");
        driver.navigate().to("https://duckduckgo.com/");

        //Pages initialization
        duckduckgoHomePage =new DuckduckgoHomePage(driver);
    }
}
