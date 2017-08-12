package com.github.spb.tget.uitests.pages.repository;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositorySettingsPage extends Page {

    @FindBy(xpath = "//button[contains(text(),'Delete this repository')]")
    private WebElement deleteButton;

    private DriverManager driverManager;

    private DeleteRepositoryModal deleteRepositoryModal;

    public RepositorySettingsPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        deleteRepositoryModal = new DeleteRepositoryModal(driver);
        initElements(driver, this);
    }

    public RepositorySettingsPage clickDeleteRepositoryButton() {
        driverManager.click(deleteButton);
        return this;
    }

    public void confirmRepositoryNameInModal(String repositoryName) {
        deleteRepositoryModal.enterRepositoryName(repositoryName).confirm();
    }

    public Boolean isAt(String userName, String repositoryName) {
        return driverManager.getDriver().getCurrentUrl()
                .equals(String.format("%s/%s/%s/settings", getBaseUrl(), userName, repositoryName));
    }

    class DeleteRepositoryModal {

        @FindBy(xpath = "//*[@id=\"facebox\"]/div/div/form/p/input")
        private WebElement confirmRepositoryNameTextField;

        @FindBy(xpath = "//*[@id=\"facebox\"]/div/div/form/button")
        private WebElement confirmButton;

        public DeleteRepositoryModal(WebDriver driver) {
            initElements(driver, this);
        }

        DeleteRepositoryModal enterRepositoryName(String repositoryName) {
            driverManager.sendInput(confirmRepositoryNameTextField, repositoryName);
            return this;
        }

        DeleteRepositoryModal confirm() {
            driverManager.click(deleteButton);
            return this;
        }
    }
}
