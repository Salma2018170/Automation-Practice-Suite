package synchronization.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org. testng.Assert.assertEquals;

import java.time.Duration;

public class WaitingStrategies {
    //Driver initialization
    private WebDriver driver;

    //Duration.ofSeconds(2) is a constant value

    private final Duration DURATION = Duration.ofSeconds(2);

    //Wait initialization
   private Wait<WebDriver> wait;

    //LOCATOR
    By addBoxButton = By.xpath("//input[@id='adder']");
    By box = By.xpath("//div[@id='box0']");

    By box1 = By.id("box0");


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
/// /////////////////////////////////////
      String  getDomAttribute=  driver.findElement(box).getDomAttribute("style");
        System.out.println("getDomAttribute: " + getDomAttribute);
        /// ///
        String  getDomProperty=  driver.findElement(box).getDomProperty("style");
        System.out.println("getDomAttribute: " + getDomAttribute);
        /// ///
        String  getAttribute=  driver.findElement(box).getAttribute("style");
        System.out.println("getDomAttribute: " + getDomAttribute);

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

        String  getDomAttribute=  driver.findElement(box).getDomAttribute("color");
        System.out.println("getDomAttribute: " + getDomAttribute);
        /// ///
        String  getDomProperty=  driver.findElement(box).getDomProperty("color");
        System.out.println("getDomProperty: " + getDomProperty);
        /// ///
        String  getAttribute=  driver.findElement(box).getAttribute("color");
        System.out.println("getAttribute: " + getAttribute);


    }
    //passed test
    @Test
    public void explicitWaitStrategy() {
        driver.findElement(addBoxButton).click();
        ///wait for the box to be displayed

        wait = new WebDriverWait(driver,DURATION);
        wait.until(d -> driver.findElement(box).isDisplayed());
                //.isDisplayed());
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
                        .pollingEvery(Duration.ofMillis(300)) //kol 2dayh hro7 abos 3la browser
                        .ignoring(NoSuchElementException.class)
                        .ignoring(ElementNotInteractableException.class)
                        .ignoring(StaleElementReferenceException.class);

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

    @Test
    public void bestPracticeNote1(){
        //option1
        By addBoxButton = By.xpath("//input[@id='adder']");
        driver.findElement(addBoxButton).click();
        //option2 very recommended to use NOT cause stale element exception (minimize the risk of stale element exception)
        driver.findElement(By.xpath("//input[@id='adder']")).click();
        //option3 cause stale element exception and not recommended to use
        WebElement element=driver.findElement(addBoxButton);
        element.click();



    }

    //Passed test
    @Test
    public void practiceTest() {
        driver.manage().timeouts().implicitlyWait(DURATION);
        // addtextbox
        By boxText=By.id("revealed");
        driver.findElement(By.id("reveal")).click();

        String  getDomAttribute=  driver.findElement(boxText).getDomAttribute("style");
        System.out.println("getDomAttribute: " + getDomAttribute);
        /// ///
        String  getDomProperty=  driver.findElement(boxText).getDomProperty("color");
        System.out.println("getDomProperty: " + getDomProperty);
        /// ///
        String  getAttribute=  driver.findElement(boxText).getAttribute("color");
        System.out.println("getAttribute: " + getAttribute);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
