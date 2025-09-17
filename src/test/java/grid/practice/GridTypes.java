package grid.practice;

import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.w3schools.W3schoolsPage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class GridTypes {


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
    public void  setup() throws URISyntaxException, MalformedURLException {
//        ConfigReader.loadProperties();
//        driver= WebBrowserFactory.getDriver();
//        driver.navigate().to(url);
        //Pages implementation

        ChromeOptions options = new ChromeOptions();
        driver =new RemoteWebDriver(new URI("http://localhost:4444").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to(url);
        w3schoolsPage=new W3schoolsPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
