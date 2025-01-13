package web.pages.theinternetherokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TheInternetHomePage {

    // Driver initialization
    private WebDriver driver;

    //url
    String url="https://the-internet.herokuapp.com/";

    // Locators

    By checkBoxesLink=By.xpath("//a[text()='Checkboxes']");

    // Constructor
    public TheInternetHomePage(WebDriver driver){
        this.driver=driver;
    }

    //Actions (Methods)

    public TheInternetHomePage navigateToTheInternetHome(){
      driver.navigate().to(url);
      return this;
    }

    public CheckBoxesPage goToCheckBoxesPage(){
        driver.findElement(checkBoxesLink).click();
        return new CheckBoxesPage(driver);}


}
