package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected DriverManager driverManager;

    public Page(WebDriver driver) {
        this.driverManager = new DriverManager(driver);
    }

    public String getBaseUrl() {
        return "https://github.com";
    }

    public abstract String getUrl(String... urlParams);
}
