package com.github.spb.tget.uitests.pages;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class PageFactory<T extends Page> {

    private WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public T createPage(Type pageType) {
        try{
            Class<?> classType = Class.forName(pageType.getTypeName());
            Constructor<?> constructor = classType.getConstructor(WebDriver.class);
            return (T)constructor.newInstance(driver);
        }
        catch (Exception e){return null;}
    }
}
