package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ProfileSettingsPage {

    private DriverManager driverManager;

    @FindBy(css = "a[href=\"/settings/repositories\"]")
    private WebElement repositoriesLink;

    public ProfileSettingsPage(WebDriver driver) {
        DriverManager driverManager = new DriverManager(driver);
        initElements(driver, this);
    }
}
