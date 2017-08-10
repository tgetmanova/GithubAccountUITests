package com.github.spb.tget.uitests.pages.repository;

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

    public RepositoryDeleteConfirmationPage(WebDriver driver) {
        initElements(driver, this);
    }

    public RepositoryDeleteConfirmationPage withPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public RepositoryDeleteConfirmationPage confirm(){
        confirmPasswordButton.click();
        return this;
    }
}
