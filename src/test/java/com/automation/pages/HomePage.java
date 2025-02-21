package com.automation.pages;

import com.automation.utils.DriverManager;
import com.automation.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    private WebElement loggedUserElement;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(className = "footer-bottom")
    private WebElement footerBottomElement;

    @FindBy(id = "scrollUp")
    private WebElement scrollUpElement;

    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscriptionElement;

    By deleteLinkBy = By.cssSelector("[href='/delete_account']");
    By loggedUserElementBy = By.className("fa-user");
    public boolean isHomePageVisible() {
        return girlImgResponsive.isDisplayed();
    }

    public void clickOnSignupLoginButton(){
        clickOnElement(signupLoginButton);
    }

    public String getLoggedUserText(){
        Waits.waitToElementIsClickable(loggedUserElement);
        return loggedUserElement.getText().trim();
    }

    public void clickOnDeleteAccountButton(){
        clickOnElement(driver.findElement(deleteLinkBy));
    }

    public void clickOnProductsButton(){
        clickOnElement(productsButton);
    }

    public void clickOnCartButton(){
        clickOnElement(cartButton);
    }

    public void scrollInToFooterBottom(){
        scrollInToElement(footerBottomElement);
        Waits.waitToElementIsVisible(footerBottomElement);
    }

    public void clickOnScrollUpButton(){
        clickOnElementJS(scrollUpElement);
    }

    public String getSubscriptionText(){
        Waits.waitToElementIsClickable(subscriptionElement);
        return subscriptionElement.getText();
    }

}
