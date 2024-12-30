package synchronization.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

public class WaitingStrategies {
    //Driver initialization
    private WebDriver driver;

    //Duration.ofSeconds(2) is a constant value

    private final Duration DURATION = Duration.ofSeconds(30);

    //Wait initialization
   private Wait<WebDriver> wait;

    //LOCATOR
    By addBoxButton = By.xpath("//input[@id='adder']");
    By box = By.xpath("//div[@id='box0']");


    // Print the retrieved color for debugging purposes
           // System.out.println("Background color: " + backgroundColor);




    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.manage().window().maximize();

    }


    //Failed test
    @Test
    public void linerWait() {
        driver.findElement(addBoxButton).click();
        String backgroundColor= driver.findElement(box).getCssValue("background-color");
        System.out.println("Background color: " + backgroundColor);
        String expectedColor = "rgba(255, 0, 0, 1)";
        assertEquals(backgroundColor, expectedColor);


    }

    //Passed test
    @Test
    public void implicitWaitStrategy() {
        driver.manage().timeouts().implicitlyWait(DURATION);
        driver.findElement(addBoxButton).click();
        String backgroundColor= driver.findElement(box).getCssValue("background-color");
        System.out.println("Background color: " + backgroundColor);
        String expectedColor = "rgba(255, 0, 0, 1)";
        assertEquals(backgroundColor, expectedColor);

    }
    //passed test
    @Test
    public void explicitWaitStrategy() {
        driver.findElement(addBoxButton).click();
        ///wait for the box to be displayed

        wait = new WebDriverWait(driver,DURATION);
        wait.until(d -> driver.findElement(box).isDisplayed());
        ///////////////
        String backgroundColor= driver.findElement(box).getCssValue("background-color");
        System.out.println("Background color: " + backgroundColor);
        String expectedColor = "rgba(255, 0, 0, 1)";
        assertEquals(backgroundColor, expectedColor);
    }
 //PASSED TEST
    @Test
    public void customizeWaitStrategy() {
        driver.findElement(addBoxButton).click();
       // String backgroundColor="";
         wait =
                new FluentWait<>(driver)
                        .withTimeout(DURATION)
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(NoSuchElementException.class)
                        .ignoring(ElementNotInteractableException.class);

        wait.until(
                d -> {
                    driver.findElement(box).isDisplayed();
                    return true;
                });
        String backgroundColor= driver.findElement(box).getCssValue("background-color");
        System.out.println("Background color: " + backgroundColor);
        String expectedColor = "rgba(255, 0, 0, 1)";
        assertEquals(backgroundColor, expectedColor);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
