package com.automation.pages;

import com.automation.utils.Waits;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends  BasePage{

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title.text-center")
    private WebElement productsTitleTextCenterElement;

    @FindBy(id = "search_product")
    private WebElement searchProductInput;

    @FindBy(id = "submit_search")
    private WebElement submitSearchButton;

    @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
    private List<WebElement> searchResultsNames;

//    @FindBy(css = "a[data-product-id='1']")
//    private WebElement addToCartButton1;
//
//    @FindBy(css = "a[data-product-id='2']")
//    private WebElement addToCartButton2;

    @FindBy(css = "button[data-dismiss='modal']")
    private WebElement continueShoppingButton;



    public String getProductsCenterTitleText(){
        Waits.waitToElementIsClickable(productsTitleTextCenterElement);
        return productsTitleTextCenterElement.getText();
    }



    public void fillSearchProduct(String productName){
        fillInput(searchProductInput, productName);
    }

    public void clickOnSubmitSearchButton(){
        submitSearchButton.click();
    }

    public void searchProduct(String productName) {
        fillSearchProduct(productName);
        clickOnSubmitSearchButton();
    }

    public List<String> getProductsSearchNames() {
        return searchResultsNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public boolean isSearchedTextContainsInProductsSearchResult(String searchText){
        System.out.println(getProductsSearchNames());
        return getProductsSearchNames().stream().allMatch(s -> s.contains(searchText));
    }

    public void addProductsToCart() throws InterruptedException {
        List<WebElement>  items = driver.findElement(By.className("features_items")).findElements(By.className("single-products"));
        WebElement firstItem = items.get(0);
        scrollInToElement(firstItem);
        Actions action = new Actions(driver);
        action.moveToElement(firstItem).build().perform();
        Thread.sleep(2000);

        WebElement addToCartButton1 = firstItem.findElement(By.className("product-overlay")).findElement(By.className("add-to-cart"));
        clickOnElementJS(addToCartButton1);
        clickOnElement(continueShoppingButton);


        action.moveToElement(items.get(1)).build().perform();
        Thread.sleep(2000);

        WebElement addToCartButton2 = items.get(1).findElement(By.className("add-to-cart"));
        clickOnElementJS(addToCartButton2);
        clickOnElement(continueShoppingButton);
    }





}
