package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.utils.DriverManager;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ScrollUpButtonTest extends BaseTest {
    HomePage homePage;
    public ScrollUpButtonTest(){
        homePage = new HomePage(DriverManager.getDriver());
    }

    @Test(description = "Scroll up button test")
    public void scrollUpButtonTest() {
        SoftAssert softAssert = new SoftAssert();

        Allure.step("Verify that home page is visible successfully");
        softAssert.assertTrue(homePage.isHomePageVisible());

        Allure.step("Scroll down page to bottom");
        homePage.scrollInToFooterBottom();

        Allure.step("Verify 'SUBSCRIPTION' is visible");
        softAssert.assertEquals(homePage.getSubscriptionText(), "SUBSCRIPTION");

        Allure.step("Click on arrow at bottom right side to move upward");
        homePage.clickOnScrollUpButton();

        Allure.step("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        Assert.assertTrue(homePage.isHomePageVisible());





    }
}
