package com.automation.tests;

import com.automation.pages.*;
import com.automation.utils.DriverManager;
import com.automation.utils.HttpClient;
import com.automation.utils.RandomDataManager;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class PlaceOrderTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    AccountDeletedPage accountDeletedPage;

    public PlaceOrderTest() {
        homePage = new HomePage(DriverManager.getDriver());
        loginPage = new LoginPage(DriverManager.getDriver());
        productsPage = new ProductsPage(DriverManager.getDriver());
        cartPage = new CartPage(DriverManager.getDriver());
        checkoutPage = new CheckoutPage(DriverManager.getDriver());
        paymentPage = new PaymentPage(DriverManager.getDriver());
        accountDeletedPage = new AccountDeletedPage(DriverManager.getDriver());
    }




    @Test(description = "Place Order")
    public void placeOrderTest() throws IOException, ParseException, InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Allure.step("Create User from API");
        HttpClient.createUser();

        Allure.step("Click 'Signup / Login' button");
        homePage.clickOnSignupLoginButton();

        Allure.step("Fill email, password and click 'Login' button");
        loginPage.fillLoginEmail(RandomDataManager.getRandomEmail());
        loginPage.fillLoginPassword(RandomDataManager.getRandomPassword());
        loginPage.clickOnLoginButton();

        Allure.step("Verify 'Logged in as username' at top");
        softAssert.assertEquals(homePage.getLoggedUserText(),RandomDataManager.getRandomName());

        Allure.step("Click on 'Products' button");
        homePage.clickOnProductsButton();

        Allure.step("Add products to cart");
        productsPage.addProductsToCart();

        Allure.step("Click 'Cart' button");
        homePage.clickOnCartButton();

        Allure.step("Verify that cart page is displayed");
        homePage.clickOnCartButton();
        softAssert.assertEquals(cartPage.getShoppingCartText(), "Shopping Cart");

        Allure.step("Click Proceed To Checkout");
        cartPage.clickOnProceedToCheckoutButton();

        Allure.step("Verify Address Details and Review Your Order");
        softAssert.assertEquals(checkoutPage.getDeliveryAddress().get(0), "YOUR DELIVERY ADDRESS");
        softAssert.assertEquals(checkoutPage.getBillingAddress().get(0), "YOUR BILLING ADDRESS");
        softAssert.assertTrue(checkoutPage.isBillingAddressEqualDeliveryAddress());
        softAssert.assertEquals(checkoutPage.getProductsNames().get(0), "Blue Top");
        softAssert.assertEquals(checkoutPage.getProductsNames().get(1), "Men Tshirt");
        softAssert.assertEquals(checkoutPage.getProductTotalPrice(), "Rs. 900");

        Allure.step("Enter description in comment text area and click 'Place Order'");
        checkoutPage.fillComment("comment test");
        checkoutPage.clickOnPlaceOrderButton();

        Allure.step("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        paymentPage.fillPaymentDetails("Poxox Poxosyan","1234567891234567" , 123,12,2025);

        Allure.step("Click 'Pay and Confirm Order' button");
        paymentPage.clickOnPayAndConfirmOrderButton();

        Allure.step("Verify success message 'Your order has been placed successfully!'");
        softAssert.assertEquals(paymentPage.getSuccessMessage(),"Congratulations! Your order has been confirmed!");

        Allure.step("Click 'Delete Account' button");
        homePage.clickOnDeleteAccountButton();

        Allure.step("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        softAssert.assertEquals(accountDeletedPage.getAccountDeletedText(),"ACCOUNT DELETED!");

    }
}