package com.github.spb.tget.uitests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class ConfirmationWithPasswordPage extends Page {

    @FindBy(id = "sudo_password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Confirm password')]")
    private WebElement confirmPasswordButton;

    public ConfirmationWithPasswordPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmationWithPasswordPage withPassword(String password) {
        driverManager.sendInput(passwordField, password);
        return this;
    }

    public void confirm() {
        driverManager.click(confirmPasswordButton);
    }

    public abstract String getUrl(String... urlParams);
}
