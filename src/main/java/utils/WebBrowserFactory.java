package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBrowserFactory {

// !!!!! I want to trace this method to see why developer is not used
    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser", "chrome");
        WebDriver driver = null;

        if ("chrome".equalsIgnoreCase(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {

            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver;
    }

}
