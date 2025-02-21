package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage{

    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement nameOnCardInput;

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement cvcInput;

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement expirationMonthInput;

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement expirationYearInput;

    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement payAndConfirmOrderButton;

    @FindBy(css = "div[class='col-sm-9 col-sm-offset-1'] p")
    private WebElement successMessageElement;

    public void fillNameOnCard(String nameOnCard){
        fillInput(nameOnCardInput, nameOnCard);
    }

    public void fillCardNumber(String cardNumber) {
        fillInput(cardNumberInput, cardNumber);
    }

    public void fillCvs(int cvs){
        fillInput(cvcInput, Integer.toString(cvs));
    }

    public void fillExpirationMonth(int expirationMonth){
        fillInput(expirationMonthInput, Integer.toString(expirationMonth));
    }

    public void fillExpirationYear(int expirationYear) {
        fillInput(expirationYearInput, Integer.toString(expirationYear));
    }

    public void clickOnPayAndConfirmOrderButton(){
        payAndConfirmOrderButton.click();
    }

    public void fillPaymentDetails(String cardName, String cardNumber, int cvc, int expirationMonth, int expirationYear) {
        fillNameOnCard(cardName);
        fillCardNumber(cardNumber);
        fillCvs(cvc);
        fillExpirationMonth(expirationMonth);
        fillExpirationYear(expirationYear);
    }

    public String getSuccessMessage(){
        return successMessageElement.getText().trim();
    }
}
