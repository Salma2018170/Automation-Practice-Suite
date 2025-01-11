package testNg.practice;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.DuckduckgoHomePage;

public class BeforeClassTest {
  //Driver initialization
    WebDriver driver;
  // Pages initialization
    DuckduckgoHomePage duckduckgoHomePage;



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
    @BeforeClass
    public void  setup() {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
        //driver=new ChromeDriver();
        //driver.get("https://duckduckgo.com/");
        driver.navigate().to("https://duckduckgo.com/");

        //Pages initialization
        duckduckgoHomePage =new DuckduckgoHomePage(driver);
    }
    @AfterClass
    public void  tearDown() {

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
