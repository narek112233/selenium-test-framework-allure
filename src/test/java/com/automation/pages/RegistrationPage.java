package com.automation.pages;

import com.automation.utils.CheckBox;
import com.automation.utils.JSONReader;
import com.automation.utils.Waits;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class RegistrationPage extends BasePage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(id = "id_gender1")
    private WebElement titleMrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement titleMrsRadioButton;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckboxElement;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckboxElement;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelectElement;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;


    public boolean isEnterAccountInformationVisible(){
        return  enterAccountInformation.isDisplayed();
    }

    public void checkGenderRadioButton(String gender){

        if (gender.equalsIgnoreCase("mr")) {
            titleMrRadioButton.click();
        } else {
            titleMrsRadioButton.click();
        }
    }

    public void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void selectDay(String day) {
        Select days = new Select(daysSelect);
        days.selectByValue(day);
    }
    public void selectMonths(String month) {
        Select months = new Select(monthsSelect);
        months.selectByValue(month);
    }

    public void selectYear(String year) {
        Select years = new Select(yearsSelect);
        years.selectByValue(year);
    }

    public void selectBirthDate(String birthDate){
       String[] birthDateArray =  birthDate.split("/");
       selectDay(birthDateArray[0]);
       selectMonths(birthDateArray[1]);
       selectYear(birthDateArray[2]);
    }

    public void checkNewsletterCheckbox() {
        CheckBox newsletterCheckbox = CheckBox.getInstance(newsletterCheckboxElement);
        newsletterCheckbox.check();
    }

    public void checkSpecialOffersCheckbox() {
        CheckBox specialOffersCheckbox = CheckBox.getInstance(specialOffersCheckboxElement);
        specialOffersCheckbox.check();
    }

    public void fillFirstName(String firstName){
        fillInput(firstNameInput, firstName);
    }
    public void fillLastName(String lastName) {
        fillInput(lastNameInput, lastName);
    }

    public void fillCompany(String companyName){
        fillInput(companyInput, companyName);
    }

    public void fillAddress1(String address1){
        fillInput(address1Input, address1);
    }

    public void fillAddress2(String address2){
        fillInput(address2Input, address2);
    }

    public void selectCountry(String countryName){
        Select countrySelect = new Select(countrySelectElement);
        countrySelect.selectByValue(countryName);
    }

    public void fillState(String stateName){
        fillInput(stateInput, stateName);
    }

    public void fillCity(String cityName){
        fillInput(cityInput, cityName);
    }

    public void fillZipCode(int zipCode){
        fillInput(zipcodeInput, Integer.toString(zipCode));
    }

    public void fillMobileNumber(int mobileNumber){
        fillInput(mobileNumberInput, Integer.toString(mobileNumber));
    }

    public void clickOnCreateAccountButton(){
        clickOnElement(createAccountButton);
    }

    public void fillNewUserData() throws IOException, ParseException {
        JSONObject userTestDataJson = JSONReader.getUserTestJsonData();
        fillFirstName(userTestDataJson.get("firstName").toString());
        fillLastName(userTestDataJson.get("lastName").toString());
        fillCompany(userTestDataJson.get("company").toString());
        fillAddress1(userTestDataJson.get("address1").toString());
        fillAddress2(userTestDataJson.get("address2").toString());
        selectCountry(userTestDataJson.get("country").toString());
        fillState(userTestDataJson.get("state").toString());
        fillCity(userTestDataJson.get("city").toString());
        fillZipCode(Integer.parseInt(userTestDataJson.get("zipcode").toString()));
        fillMobileNumber(Integer.parseInt(userTestDataJson.get("mobileNumber").toString()));
    }

}
