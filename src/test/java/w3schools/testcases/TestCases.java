package w3schools.testcases;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org. testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import engine.ConfigReader;
import engine.WebBrowserFactory;
import web.pages.w3schools.W3schoolsPage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TestCases {

    //URL initialization
    String url="https://www.w3schools.com/html/html_tables.asp";

    //Driver initialization
    WebDriver driver;

    //Pages initialization
     private W3schoolsPage w3schoolsPage;

    @Description("assert for company Task7")
    @Test
    public void assertForTheCountryTask7(){
        String strCountryName=w3schoolsPage.getCountryName();
        Assert.assertEquals(strCountryName,"Austria");

    }
    @BeforeMethod
    public void  setup() throws MalformedURLException, URISyntaxException {

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
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


