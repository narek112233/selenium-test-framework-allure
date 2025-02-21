package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BasePage {

    WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement accountCreated;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    public boolean isAccountCreatedVisible(){
        return accountCreated.isDisplayed();
    }

    public void clickOnContinueButton(){
       clickOnElement(continueButton);
    }

}
