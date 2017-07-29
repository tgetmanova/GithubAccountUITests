package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import static com.github.spb.tget.uitests.maps.elements.UserProfileDropDown.*;
import static com.github.spb.tget.uitests.maps.elements.NewDropDown.*;

public class TopPane {

    private DriverManager driverManager;

    public TopPane(WebDriver driver) {
        driverManager = new DriverManager(driver);
    }

    private Boolean isUserProfileDropDownExpanded = false;

    private Boolean isNewDropDownExpanded = false;

    private String topMenuDropDownCollapsedMessage = "\nCannot select items in drop-down as it is collapsed. " +
            "\nExpand the drop-down before selecting items in it.";

    public TopPane expandUserProfileDropDown() {
        driverManager.getDriver().findElement(profileDropDownLink()).click();
        isUserProfileDropDownExpanded = true;
        return this;
    }

    public TopPane expandNewDropDown() {
        driverManager.getDriver().findElement(newDropDownLink()).click();
        isNewDropDownExpanded = true;
        return this;
    }

    public void selectSettingsInDropDown() {
        if (!isUserProfileDropDownExpanded) {
            throw new WebDriverException(topMenuDropDownCollapsedMessage);
        }
        driverManager.getDriver().findElement(settingsLink()).click();
        resetDropDownsState();
    }

    public void selectNewRepositoryInDropDown() {
        if (!isNewDropDownExpanded) {
            throw new WebDriverException(topMenuDropDownCollapsedMessage);
        }
        driverManager.getDriver().findElement(newRepositoryLink()).click();
        resetDropDownsState();
    }

    private void resetDropDownsState() {
        isNewDropDownExpanded = false;
        isUserProfileDropDownExpanded = false;
    }
}
