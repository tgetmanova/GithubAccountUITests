package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static com.github.spb.tget.uitests.maps.HomePageMap.*;

public class HomePage extends Page {

    private DriverManager driverManager;

    public HomePage(WebDriver driver) {
        driverManager = new DriverManager(driver);
    }

    public String getUrl() {
        return getBaseUrl();
    }

    public void goTo() {
        driverManager.getDriver().navigate().to(getUrl());
    }

    public void clickSignIn() {
        driverManager.getDriver().findElement(signInLink()).click();
    }
}
