package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();
    static {
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Fail to load  config.properties: " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return System.getProperty(("base.url"), properties.getProperty("base.url"));
    }


}
