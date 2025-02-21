package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.DriverManager;
import com.automation.utils.RandomDataManager;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class RegisterUserTest extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    RegistrationPage registrationPage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;

    public RegisterUserTest(){
        homePage = new HomePage(DriverManager.getDriver());
        loginPage = new LoginPage(DriverManager.getDriver());
        registrationPage = new RegistrationPage(DriverManager.getDriver());
        accountCreatedPage = new AccountCreatedPage(DriverManager.getDriver());
        accountDeletedPage = new AccountDeletedPage(DriverManager.getDriver());
    }


    @Test(description = "Register User")
    public void userRegisterTest() throws IOException, ParseException {
        SoftAssert softAssert = new SoftAssert();

        Allure.step("Verify that home page is visible successfully");
        softAssert.assertTrue(homePage.isHomePageVisible());

        Allure.step("Click on 'Signup / Login' button");
        homePage.clickOnSignupLoginButton();

        Allure.step("Verify 'New User Signup!' is visible");
        softAssert.assertEquals(loginPage.getNewUserSignupText(), "New User Signup!");

        Allure.step("Enter name and email address");
        loginPage.fillSignupName(RandomDataManager.getRandomName());
        loginPage.fillSignupEmail(RandomDataManager.getRandomEmail());

        Allure.step("Click 'Signup' button");
        loginPage.clickOnSignupButton();

        Allure.step("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        softAssert.assertTrue(registrationPage.isEnterAccountInformationVisible());

        Allure.step("Fill details: Title, Name, Email, Password, Date of birth");
        registrationPage.checkGenderRadioButton("Mr");
        registrationPage.fillPassword(RandomDataManager.getRandomPassword());
        registrationPage.selectBirthDate("8/8/1987");

        Allure.step("Select checkbox 'Sign up for our newsletter!'");
        registrationPage.checkNewsletterCheckbox();

        Allure.step("Select checkbox 'Receive special offers from our partners!'");
        registrationPage.checkSpecialOffersCheckbox();

        Allure.step("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        registrationPage.fillNewUserData();

        Allure.step("Click 'Create Account button'");
        registrationPage.clickOnCreateAccountButton();

        Allure.step("Verify that 'ACCOUNT CREATED!' is visible");
        softAssert.assertTrue(accountCreatedPage.isAccountCreatedVisible());

        Allure.step("Click 'Continue' button");
        accountCreatedPage.clickOnContinueButton();

        Allure.step("Verify that 'Logged in as username' is visible");
        System.out.println("homePage.getLoggedUserText() " + homePage.getLoggedUserText());
        System.out.println("Logged in as "+ RandomDataManager.getRandomName());
        softAssert.assertEquals(homePage.getLoggedUserText(), RandomDataManager.getRandomName());

        Allure.step("Click 'Delete Account' button");
        homePage.clickOnDeleteAccountButton();

        Allure.step("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        softAssert.assertEquals(accountDeletedPage.getAccountDeletedText(),"ACCOUNT DELETED!");
    }
}
