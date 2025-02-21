package com.automation.utils;

import org.openqa.selenium.WebElement;

public class CheckBox {
    WebElement checkBoxElement;

    private CheckBox(WebElement checkBoxElement){
        this.checkBoxElement = checkBoxElement;
    }

    public static CheckBox getInstance(WebElement checkBoxElement)  {
        return new CheckBox(checkBoxElement);
    }

    public void check(){
        if(!this.checkBoxElement.isSelected()){
            checkBoxElement.click();
        }
    }

    public void unCheck(WebElement checkBoxElement){
        if(checkBoxElement.isSelected()){
            checkBoxElement.click();
        }
    }
}
