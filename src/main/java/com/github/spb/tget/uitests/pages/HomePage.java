package com.github.spb.tget.uitests.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends Page{
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl(){
        return this.getBaseUrl();
    }

    public void goTo(){
        this.driver.navigate().to(getUrl());
    }
}
