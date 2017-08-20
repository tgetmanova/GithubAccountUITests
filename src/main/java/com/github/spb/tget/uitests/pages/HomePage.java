package com.github.spb.tget.uitests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage extends Page {

    @FindBy(css="a[href=\"/login\"]")
    private WebElement signInLink;

    @FindBy(xpath = "/html/body/div[1]/header/div/button")
    private WebElement topPaneItemsButton;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements(driver, this);
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

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl();
    }
}