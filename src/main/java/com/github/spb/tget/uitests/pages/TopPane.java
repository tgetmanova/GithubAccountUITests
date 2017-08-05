package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class TopPane {

    @FindBy(css = "a[href=\"/new\"]")
    private WebElement newDropDownLink;

    @FindBy(linkText = "New repository")
    private WebElement newRepositoryLink;

    @FindBy(css = "img[alt=\"@githubTestUser191\"]")
    private WebElement profileDropDownLink;

    @FindBy(css = "a[href=\"/settings/profile\"]")
    private WebElement settingsLink;

    private Boolean isUserProfileDropDownExpanded = false;

    private Boolean isNewDropDownExpanded = false;

    private String topMenuDropDownCollapsedMessage = "\nCannot select items in drop-down as it is collapsed. " +
            "\nExpand the drop-down before selecting items in it.";

    private DriverManager driverManager;

    public TopPane(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public WebElement getProfileDropDownLink() {
        return profileDropDownLink;
    }

    public TopPane expandUserProfileDropDown() {
        profileDropDownLink.click();
        isUserProfileDropDownExpanded = true;
        return this;
    }

    public TopPane expandNewDropDown() {
        newDropDownLink.click();
        isNewDropDownExpanded = true;
        return this;
    }

    public void selectSettingsInDropDown() {
        if (!isUserProfileDropDownExpanded) {
            throw new WebDriverException(topMenuDropDownCollapsedMessage);
        }
        settingsLink.click();
        resetDropDownsState();
    }

    public void selectNewRepositoryInDropDown() {
        if (!isNewDropDownExpanded) {
            throw new WebDriverException(topMenuDropDownCollapsedMessage);
        }
        newRepositoryLink.click();
        resetDropDownsState();
    }

    private void resetDropDownsState() {
        isNewDropDownExpanded = false;
        isUserProfileDropDownExpanded = false;
    }
}
