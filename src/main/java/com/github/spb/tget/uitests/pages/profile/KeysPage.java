package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KeysPage extends Page {

    @FindBy(id = "add_key_action")
    private WebElement newSshKeyButton;

    @FindBy(xpath = "//button[contains(text(), 'Add SSH key')]")
    private WebElement addSshKeyButton;

    @FindBy(id = "public_key_title")
    private WebElement sshKeyTitleTextField;

    @FindBy(id = "public_key_key")
    private WebElement sshKeyValueTextField;

    private WebElement sshKeyHeader;

    public KeysPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isAt(){
        return driverManager.getDriver().getCurrentUrl().equals(getUrl());
    }

    public KeysPage expandSshKeyCreationForm() {
        if (isSshKeyBeingAdded()) {
            throw new IllegalStateException("SSH Keu creation form is currently expanded, you click to collapse it");
        }
        newSshKeyButton.click();
        return this;
    }

    public KeysPage withSshKeyTitle(String title) {
        sshKeyTitleTextField.sendKeys(title);
        return this;
    }

    public KeysPage withSshKeyValue(String value) {
        sshKeyValueTextField.sendKeys(value);
        return this;
    }

    public void submitNewSshKey() {
        addSshKeyButton.click();
    }

    private Boolean isSshKeyBeingAdded() {
        return addSshKeyButton.isDisplayed();
    }

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl() + "/settings/keys";
    }
}
