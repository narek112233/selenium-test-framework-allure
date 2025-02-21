package com.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomDataManager {

    private static String  name = "name"+getCurrentDateTime();
    private static  String  password = "password"+getCurrentDateTime();
    private static  String email = "email"+getCurrentDateTime()+"@test.com";

    private static String getCurrentDateTime(){
        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date());
    }
    public static String getRandomName(){
        return name;
    }

    public static String getRandomEmail(){
        return email;
    }

    public static String getRandomPassword(){
        return password;
    }

}
