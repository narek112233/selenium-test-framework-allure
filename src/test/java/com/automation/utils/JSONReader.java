package com.automation.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    public static JSONObject getUserCreateJsonData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\UserCreate.json");
        Object obj = jsonParser.parse(fileReader);
        fileReader.close();

        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        } else {
            return new JSONObject();
        }
    }

    public static JSONObject getUserTestJsonData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader("src\\test\\resources\\UserTestData.json");
        Object obj = jsonParser.parse(fileReader);
        fileReader.close();

        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        } else {
            return new JSONObject();
        }
    }

}
