package com.automation.pages;

import com.automation.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage{

    WebDriver driver;

    public CartPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li[class='active']")
    private WebElement shoppingCart;

    @FindBy(css = "a[class='btn btn-default check_out']")
    private WebElement proceedToCheckoutButton;




    public String getShoppingCartText(){
        return  shoppingCart.getText();
    }

    public void clickOnProceedToCheckoutButton(){
        clickOnElement(proceedToCheckoutButton);
    }



}
