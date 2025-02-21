package com.automation.pages;

import com.automation.utils.DriverManager;
import com.automation.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(DriverManager.getDriver());
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class='signup-form'] h2")
    private WebElement newUserSignupTextElement;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;


    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;


    public String getNewUserSignupText(){
        Waits.waitToElementIsVisible(newUserSignupTextElement);
        return newUserSignupTextElement.getText();
    }

    public void fillSignupEmail(String email){
         fillInput(signupEmailInput, email);
    }

    public void fillSignupName(String name){
        fillInput(signupNameInput, name);
    }

    public void clickOnSignupButton(){
        clickOnElement(signupButton);
    }

    public void fillLoginEmail(String email){
        fillInput(loginEmailInput, email);
    }

    public void fillLoginPassword(String password) {
        fillInput(loginPasswordInput, password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }
}
