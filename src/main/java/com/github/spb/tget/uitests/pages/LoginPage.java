package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage extends Page {
    @FindBy(id = "login_field")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(name = "commit")
    private WebElement signInField;

    private DriverManager driverManager;

    public LoginPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public String getUrl() {
        return getBaseUrl() + "/login";
    }

    public LoginPage withLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage withPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void submit() {
        driverManager.click(signInField);
    }
}