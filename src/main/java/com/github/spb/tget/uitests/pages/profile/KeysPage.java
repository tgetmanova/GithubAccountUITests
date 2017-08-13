package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

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

    private DriverManager driverManager;

    public KeysPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public Boolean isAt(){
        return driverManager.getDriver().getCurrentUrl().equals(getBaseUrl() + "/settings/keys");
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
}
