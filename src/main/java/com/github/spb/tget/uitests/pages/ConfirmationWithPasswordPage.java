package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class ConfirmationWithPasswordPage extends Page{

    @FindBy(id = "sudo_password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Confirm password')]")
    private WebElement confirmPasswordButton;

    private DriverManager driverManager;

    public ConfirmationWithPasswordPage(WebDriver driver) {
        initElements(driver, this);
        driverManager = new DriverManager(driver);
    }

    public ConfirmationWithPasswordPage withPassword(String password) {
        driverManager.sendInput(passwordField, password);
        return this;
    }

    public ConfirmationWithPasswordPage confirm() {
        driverManager.click(confirmPasswordButton);
        return this;
    }

    public abstract String getUrl();
}
