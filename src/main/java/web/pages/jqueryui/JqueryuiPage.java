package web.pages.jqueryui;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class JqueryuiPage {
    //url
   private String  url = "https://jqueryui.com/resources/demos/droppable/default.html";
    // Driver initialization

    private WebDriver driver;
    //Locators
    private By dragElement=By.id("draggable");
    private By dropElement=By.id("droppable");
    // Constructor
    public JqueryuiPage(WebDriver driver) {
        this.driver = driver;
    }
    public JqueryuiPage navigateToJqueryuiPage() {
        driver.navigate().to(url);
        return this;
    }
    public JqueryuiPage dragAndDropFunc(){
        new Actions(driver).dragAndDrop( driver.findElement(dragElement), driver.findElement(dropElement)).perform();
        return this;
    }

    public JqueryuiPage assertDragAndDropSuccess() {
    Assert.assertEquals(driver.findElement(dropElement).getText(),"Dropped!","Drag and drop failed");
    Assert.assertEquals(driver.findElement(dropElement).getCssValue("background-color"),"rgba(255, 250, 144, 1)","Drag and drop colored failed");
    return this;
    }
}
