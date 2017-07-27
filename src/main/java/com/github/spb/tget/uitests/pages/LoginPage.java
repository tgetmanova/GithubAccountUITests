package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static com.github.spb.tget.uitests.maps.LoginPageMap.*;

public class LoginPage extends Page {

    private DriverManager driverManager;

    public LoginPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
    }

    public String getUrl() {
        return getBaseUrl() + "/login";
    }

    public LoginPage withLogin(String login){
        driverManager.getDriver().findElement(loginField()).sendKeys(login);
        return this;
    }

    public LoginPage withPassword(String password){
        driverManager.getDriver().findElement(passwordField()).sendKeys(password);
        return this;
    }

    public void submit(){
        driverManager.click(signInField());
    }
}
