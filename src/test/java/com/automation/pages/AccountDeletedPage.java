package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {
    WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "h2[data-qa='account-deleted']")
    private WebElement accountDeleted;

    public String getAccountDeletedText(){
        return accountDeleted.getText();
    }

}
