package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static com.github.spb.tget.uitests.maps.elements.UserProfileDropDown.*;

public class WelcomePage extends Page {

    private DriverManager driverManager;

    public WelcomePage(WebDriver driver) {
        driverManager = new DriverManager(driver);
    }

    public String getUrl() {
        return getBaseUrl();
    }

    public void goTo() {
        driverManager.getDriver().navigate().to(getUrl());
    }

    public Boolean isAt() {
        return !driverManager.getDriver().findElements(profileDropDownLink()).isEmpty();
    }
}
