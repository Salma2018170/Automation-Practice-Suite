package TheInternet.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.theinternetherokuapp.TheInternetHomePage;
import web.pages.w3schools.W3schoolsPage;

public class TestCases {
    //driver initialization
    private WebDriver driver;

    /**
     * ________________ Basic ________________
     * Open Google Chrome
     * Navigate to [http://the-internet.herokuapp.com/checkboxes]
     * Check Checkbox 1
     * Assert that both Checkboxes are checked
     * Close Google Chrome
     */
    @Test
    public void validateCheckBoxes() {
        //driver initialization
        new TheInternetHomePage(driver)
                .navigateToTheInternetHome()
                .goToCheckBoxesPage()
                .checkCheckBox1().assertCheckBoxsIsChecked();
    }
    @BeforeMethod
    public void  setup() {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
