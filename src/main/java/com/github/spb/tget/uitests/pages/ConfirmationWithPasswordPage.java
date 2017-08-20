package com.github.spb.tget.uitests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class ConfirmationWithPasswordPage extends Page{

    @FindBy(id = "sudo_password")
    protected WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Confirm password')]")
    protected WebElement confirmPasswordButton;

    public ConfirmationWithPasswordPage withPassword(String password) {
        driverManager.sendInput(passwordField, password);
        return this;
    }

    public ConfirmationWithPasswordPage confirm() {
        driverManager.click(confirmPasswordButton);
        return this;
    }

    public abstract String getUrl(String... urlParams);
}
