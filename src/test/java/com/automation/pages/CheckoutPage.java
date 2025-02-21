package com.automation.pages;

import com.automation.utils.DriverManager;
import com.automation.utils.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage extends BasePage{

    WebDriver driver;

    public CheckoutPage (WebDriver driver) {
        super(DriverManager.getDriver());
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//ul[contains(@id, 'address_delivery')]//li")
    private List<WebElement> deliveryAddressElements;

    @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
    private List<WebElement> billingAddressElements;

    @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
    private List<WebElement> productNameElements;

    @FindBy(xpath = "//*[@id=\"cart_info\"]/table/tbody/tr[3]/td[4]/p")
    private WebElement totalPriceElement;

    @FindBy(css = "textarea[name='message']")
    private WebElement commentTextArea;

    @FindBy(css = "a[href='/payment']")
    private WebElement placeOrderButton;


    public List<String> getDeliveryAddress() {
        return deliveryAddressElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getBillingAddress() {
        return billingAddressElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getProductsNames() {
        return productNameElements
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public String getProductTotalPrice() {
        return totalPriceElement.getText();
    }

    public void fillComment(String comment){
        fillInput(commentTextArea, comment);
    }

    public void clickOnPlaceOrderButton(){
       clickOnElement(placeOrderButton);
    }

    public boolean isBillingAddressEqualDeliveryAddress(){
        for(int i=1; i<getBillingAddress().size();i++){
            if(!getDeliveryAddress().get(i).equals(getBillingAddress().get(i))){
                return  false;
            }
        }
        return true;
    }
}
