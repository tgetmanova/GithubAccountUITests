package com.github.spb.tget.uitests.pages.repository;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositoryDeleteConfirmationPage extends Page {

    @FindBy(id = "sudo_password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Confirm password')]")
    private WebElement confirmPasswordButton;

    private DriverManager driverManager;

    public RepositoryDeleteConfirmationPage(WebDriver driver) {
        initElements(driver, this);
        driverManager = new DriverManager(driver);
    }

    public RepositoryDeleteConfirmationPage withPassword(String password) {
        driverManager.sendInput(passwordField, password);
        return this;
    }

    public RepositoryDeleteConfirmationPage confirm() {
        driverManager.click(confirmPasswordButton);
        return this;
    }

    @Override
    public String getUrl(String... urlParams) {
        int expectedUrlParamsNumber = 2;
        if (urlParams.length != expectedUrlParamsNumber) {
            throw new IllegalArgumentException(expectedUrlParamsNumber + " URL params number expected for the Page: "
                    + this.getClass().getSimpleName());
        }
        return getBaseUrl() + "/" + urlParams[0] + "/" + urlParams[1] + "/settings/delete";
    }
}
