package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;

public abstract class Page {

    protected DriverManager driverManager;

    public String getBaseUrl() {
        return "https://github.com";
    }

    public abstract String getUrl(String... urlParams);
}
