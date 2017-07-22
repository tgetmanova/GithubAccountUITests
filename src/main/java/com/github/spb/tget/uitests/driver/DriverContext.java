package com.github.spb.tget.uitests.driver;

import org.openqa.selenium.WebDriver;

public interface DriverContext {
    String driverExecutableName();
    WebDriver getDriver();
}
