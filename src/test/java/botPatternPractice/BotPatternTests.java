package botPatternPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class BotPatternTests {
     //driver initialization
    private WebDriver driver;
    @Test
    public void testBotPattern(){
        By textBox=By.id("my-text-id");
        driver.findElement(textBox).sendKeys("Selenium");
        var boxValue =driver.findElement(textBox).getDomProperty("value");

        assertEquals(boxValue,"Selenium");
    }
    @BeforeMethod
    public void seatUp(){
         driver=new ChromeDriver();
         driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

    }
    @AfterMethod
    public void tearDown(){
     driver.quit();
    }

}
