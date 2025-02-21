package com.automation.tests;

import com.automation.utils.ConfigManager;
import com.automation.utils.DriverManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get(ConfigManager.getBaseUrl());
    }

    @AfterSuite
    public void teardown() {
        DriverManager.quitDriver();
    }
}
