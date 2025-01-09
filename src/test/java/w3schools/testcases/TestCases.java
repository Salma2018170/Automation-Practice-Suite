package w3schools.testcases;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.DuckduckgoHomePage;
import web.pages.SearchPage;
import web.pages.W3schoolsPage;

public class TestCases {

    //URL initialization
    String url="https://www.w3schools.com/html/html_tables.asp";

    //Driver initialization
    WebDriver driver;

    //Pages initialization
     private W3schoolsPage w3schoolsPage;
    @BeforeMethod
    public void  setup() {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
        // ChromeDriver driver=new ChromeDriver();
        //driver.get("https://duckduckgo.com/");
       // driver.manage().
        driver.navigate().to(url);

        //Pages implementation
        w3schoolsPage=new W3schoolsPage(driver);


    }
    @Description("assert for company Task7")
    @Test
    public void assertForTheCountryTask7(){
        String strCountryName=w3schoolsPage.getCountryName();
        Assert.assertEquals(strCountryName,"Austria");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


