package com.automation.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;


public class Waits {
    public static void waitToElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ofSeconds(20));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
    }

    public static void waitToElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
