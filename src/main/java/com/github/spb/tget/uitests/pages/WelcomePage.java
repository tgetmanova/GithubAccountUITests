package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WelcomePage extends Page {

    private DriverManager driverManager;

    private TopPane topPane;

    public WelcomePage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);

        topPane = new TopPane(driver);
    }

    public String getUrl() {
        return getBaseUrl();
    }

    public void goTo() {
        driverManager.getDriver().navigate().to(getUrl());
    }

    public Boolean isAt() {
        return driverManager.tryFindElementElseNull(topPane.getProfileDropDownLink()) != null;
    }
}
