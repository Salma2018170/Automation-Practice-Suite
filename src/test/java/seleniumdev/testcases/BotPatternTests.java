package seleniumdev.testcases;

import engine.ActionBot;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.pages.seleniumDev.WebForm;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BotPatternTests {
    private ActionBot actionBot;

    @Test
    public void typeAndConfirmSeleniumForm() throws MalformedURLException, URISyntaxException {
        new WebForm(actionBot).navigateToForm()
                           .fillForm("TestUser"
                                   , "TestPassword"
                                   ,"This is a test comment");
        Assert.assertEquals("Seliuem",new WebForm(actionBot).getInputValue());

    }

    @BeforeMethod
    public void setUp() throws MalformedURLException, URISyntaxException {
        actionBot = new ActionBot();
    }

    @AfterMethod
    public void tearDown() {
        actionBot.quit();
    }
}
