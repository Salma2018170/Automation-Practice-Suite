package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebBrowserFactory {

// !!!!! I want to trace this method to see why default value is not used (IT'S WORKING)
    public static WebDriver getDriver() throws URISyntaxException, MalformedURLException {
        String browser = ConfigReader.getProperty("browser", "chrome");
        WebDriver driver = null;

        if ("chrome".equalsIgnoreCase(browser)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            driver = new FirefoxDriver(firefoxOptions);
        }
        else if("Remote".equalsIgnoreCase(browser)){
            //RemoteWebDriver
            ChromeOptions options = new ChromeOptions();
            driver =new RemoteWebDriver(new URI("http://localhost:4444").toURL(), options );
        }
        else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

}
