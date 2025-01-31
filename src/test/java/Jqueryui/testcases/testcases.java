package Jqueryui.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.jqueryui.JqueryuiPage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class testcases {
    //driver initialization
    private WebDriver driver;

    /**
     * ________________ Moderate ________________
     * Open Google Chrome
     * Navigate to [https://jqueryui.com/resources/demos/droppable/default.html]
     * Drag [Drag me to my target] and drop it on [Drop here]
     * Assert that the text has been changed to [Dropped!]
     * Close Google Chrome
     */

    @Test
    public void dragAndDropTest() {
        new JqueryuiPage(driver)
                .navigateToJqueryuiPage()
                .dragAndDropFunc()
                .assertDragAndDropSuccess();
    }
    @BeforeMethod
    public void  setup() throws MalformedURLException, URISyntaxException {

        //browser initialization
        ConfigReader.loadProperties();
        driver= WebBrowserFactory.getDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
