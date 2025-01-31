package TheInternet.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;
import utils.WebBrowserFactory;
import web.pages.theinternetherokuapp.TheInternetHomePage;
import web.pages.w3schools.W3schoolsPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class TestCases {
    //driver initialization
    private WebDriver driver;

    //upload a small image path
    File file = new File("src/test/resources/img-data/testUploadFiled.png");

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
    /**
     ________________ Moderate ________________
     Open Google Chrome
     Navigate to [http://the-internet.herokuapp.com/upload]
     Upload a small image file
     Assert that the file was uploaded successfully
     Close Google Chrome
     */
    @Test
    public void validateFileUpload() {
        //driver initialization
        new TheInternetHomePage(driver)
                .navigateToTheInternetHome()
                .goToFileUploadPage()
                .uploadFileImage(file.getAbsolutePath())
                .assertFileUploadSuccess("testUploadFiled.png");

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
