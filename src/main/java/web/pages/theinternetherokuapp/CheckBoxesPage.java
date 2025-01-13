package web.pages.theinternetherokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;

public class CheckBoxesPage {

    // Driver initialization
   private WebDriver driver;

   //Locators

    By checkBox1=By.xpath("//form/input[1]");
    By checkBox2=By.xpath("//form/input[2]");
    //Constructor
    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }
    public CheckBoxesPage checkCheckBox1(){
        driver.findElement(checkBox1).click();
        return this;
    }

    public CheckBoxesPage assertCheckBoxsIsChecked(){
        Assert.assertEquals(driver.findElement(checkBox1).getDomProperty("checked"),"true","Checkbox 1 is not checked");
        Assert.assertEquals(driver.findElement(checkBox2).getDomProperty("checked"),"true","Checkbox 2 is not checked");
        return this;
    }

}
