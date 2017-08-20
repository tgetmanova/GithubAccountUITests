package com.github.spb.tget.uitests.pages;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WelcomePage extends Page {

    private TopPane topPane;

    public WelcomePage(WebDriver driver) {
        super(driver);
        initElements(driver, this);

        topPane = new TopPane(driver);
    }

    public void goTo() {
        driverManager.getDriver().navigate().to(getUrl());
    }

    public Boolean isAt() {
        return driverManager.tryFindElementElseNull(topPane.getProfileDropDownLink()) != null;
    }

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl();
    }
}
