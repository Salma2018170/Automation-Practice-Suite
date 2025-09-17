package botPatternPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BotPatternTests {
     //driver initialization
    private WebDriver driver;
    @Test
    public void testBotPattern(){

    }
    @BeforeMethod
    public void seatUp(){
         driver=new ChromeDriver();
         driver.navigate().to("");

    }
    @AfterMethod
    public void tearDown(){
     driver.quit();
    }

}
