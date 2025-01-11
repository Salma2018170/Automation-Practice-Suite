package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebBrowserFactory {

// !!!!! I want to trace this method to see why default value is not used (IT'S WORKING)
    public static WebDriver getDriver() {
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
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

}
