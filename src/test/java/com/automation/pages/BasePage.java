package com.automation.pages;

import com.automation.utils.ConfigManager;
import com.automation.utils.DriverManager;
import com.automation.utils.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openApplication() {

    }

    public  void fillInput(WebElement elem , String inputValue) {
        Waits.waitToElementIsClickable(elem);
        elem.clear();
        elem.sendKeys(inputValue);
    }

    public static String getCsrfmiddlewaretoken(){
        WebElement csrfTokenElement = DriverManager.getDriver().findElement(By.name("csrfmiddlewaretoken"));
        return  csrfTokenElement.getDomAttribute("value");
    }

    public void scrollInToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void clickOnElement(WebElement element){
        Waits.waitToElementIsClickable(element);
        element.click();
    }
    public void clickOnElementJS(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }


}
