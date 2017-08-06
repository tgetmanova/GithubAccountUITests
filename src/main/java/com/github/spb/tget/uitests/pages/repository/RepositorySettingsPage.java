package com.github.spb.tget.uitests.pages.repository;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositorySettingsPage extends Page {

    @FindBy(xpath = "//button[contains(text(),'Delete this repository')]")
    private WebElement deleteButton;

    private DriverManager driverManager;

    public RepositorySettingsPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public void clickDeleteRepositoryButton(){
        deleteButton.click();
    }
}
