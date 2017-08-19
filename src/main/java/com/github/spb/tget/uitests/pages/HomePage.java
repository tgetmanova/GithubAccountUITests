package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends Page {

    @FindBy(css="a[href=\"/login\"]")
    private WebElement signInLink;

    @FindBy(xpath = "/html/body/div[1]/header/div/button")
    private WebElement topPaneItemsButton;

    private DriverManager driverManager;

    public HomePage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public String getUrl() {
        return getBaseUrl();
    }

    public void goTo() {
        driverManager.getDriver().navigate().to(getUrl());
    }

    public void clickSignIn() {
        if(!signInLink.isDisplayed()){
            topPaneItemsButton.click();
        }

        signInLink.click();
    }
}