package web.pages.theinternetherokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUpLoadPage {

    // Driver initialization
    private final WebDriver driver;
    //Locators
   private  By fileUploadFailed=By.id("file-upload");
   private  By uploadButton=By.id("file-submit");

   private By uploadedFileMassage=By.id("uploaded-files");
    // Constructor
    public FileUpLoadPage(WebDriver driver) {
        this.driver = driver;
    }

    public FileUpLoadPage uploadFileImage(String filePath){
        driver.findElement(fileUploadFailed).sendKeys(filePath);
        driver.findElement(uploadButton).click();
        return this;
    }

    public FileUpLoadPage assertFileUploadSuccess(String expectedUploadedFileName){

        String uploadedFileName=driver.findElement(uploadedFileMassage).getText();
        Assert.assertEquals(uploadedFileName,expectedUploadedFileName,"File upload failed");
        return this;
    }
}
