package web.pages.seleniumDev;

import engine.ActionBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WebForm {
    //locators for web form elements can be defined here
    By textBoxInput=By.id("my-text-id");
    By passwordInput=By.name("my-password");
    By textAreaInput=By.name("my-textarea");
    By submitButton=By.cssSelector("button[type='submit']");

    private final ActionBot actionBot;

    // Constructor
    public WebForm(ActionBot actionBot) {
        this.actionBot = actionBot;
    }

    // Methods to interact with the web form can be added here
    public WebForm navigateToForm(){
        actionBot.navigateTo("https://www.selenium.dev/selenium/web/web-form.html");
        return this;
    }
   @Step("Filling the form with text: {text}, password: {password}, comment: {comment}")
    public WebForm fillForm(String text, String password, String comment) {
        // Code to fill the form fields
        actionBot.type(textBoxInput,text)
                .type(passwordInput,password)
                .type(textAreaInput,comment);
               // .click(submitButton);
        return this;
    }
    public String getInputValue() {
        return actionBot.getDomProperty(textBoxInput, "value");
    }
}

