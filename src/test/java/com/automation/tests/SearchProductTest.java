package com.automation.tests;


import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;
import com.automation.utils.DriverManager;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchProductTest extends BaseTest {

    HomePage homePage;
    ProductsPage productsPage;

    public SearchProductTest(){
        homePage = new HomePage(DriverManager.getDriver());
        productsPage = new ProductsPage(DriverManager.getDriver());
    }

    @Test(description = "Product Search")
    public void productSearchTest() {
        SoftAssert softAssert = new SoftAssert();


        Allure.step("Verify that home page is visible successfully");
        softAssert.assertTrue(homePage.isHomePageVisible());

        Allure.step("Click on 'Products' button");
        homePage.clickOnProductsButton();

        Allure.step("Verify user is navigated to ALL PRODUCTS page successfully");
        softAssert.assertEquals(productsPage.getProductsCenterTitleText(), "ALL PRODUCTS");


        Allure.step("Enter product name in search input and click search button");
        productsPage.searchProduct("Polo");

        Allure.step("Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertEquals(productsPage.getProductsCenterTitleText(), "SEARCHED PRODUCTS");

        Allure.step("Verify all the products related to search are visible");
        Assert.assertTrue(productsPage.isSearchedTextContainsInProductsSearchResult("Polo"));

    }
}
