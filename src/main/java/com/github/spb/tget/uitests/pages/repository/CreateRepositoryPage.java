package com.github.spb.tget.uitests.pages.repository;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import com.github.spb.tget.uitests.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CreateRepositoryPage extends Page {

    @FindBy(id = "repository_name")
    private WebElement repositoryNameField;

    @FindBy(id = "repository_description")
    private WebElement repositoryDescription;

    @FindBy(id = "repository_auto_init")
    private WebElement isReadMeFileNeededCheckbox;

    @FindBy(xpath = "//*[text() = 'Add .gitignore:']")
    private WebElement addGitIgnoreButton;

    @FindBy(xpath = "//*[text() = 'Add .gitignore:']")
    private WebElement gitIgnoreField;

    @FindBy(xpath = "//button[contains(text(),'Create repository')]")
    private WebElement createRepositoryButton;

    @FindBy(css = "div[class=\"select-menu-item-text js-select-button-text\"]")
    private List<WebElement> templateDropDownItems;

    @FindBy(css = "span[class=\"js-select-button\"]")
    private WebElement addGitIgnoreButtonSelectionText;

    private DriverManager driverManager;

    public CreateRepositoryPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public Boolean isAt() {
        return driverManager.getDriver().getCurrentUrl().equals(getUrl());
    }

    public CreateRepositoryPage withRepositoryName(String repositoryName) {
        repositoryNameField.sendKeys(repositoryName);
        return this;
    }

    public CreateRepositoryPage withRepositoryDescription(String description) {
        repositoryDescription.sendKeys(description);
        return this;
    }

    public CreateRepositoryPage withIsReadMeFileNeeded(Boolean isReadMeFileNeeded) {
        if ((isReadMeFileNeeded && !isReadMeFileNeededCheckbox.isSelected())
            || (!isReadMeFileNeeded && isReadMeFileNeededCheckbox.isSelected())) {
            isReadMeFileNeededCheckbox.click();
        }
        return this;
    }

    public CreateRepositoryPage withGitIgnoreTemplate(String gitIgnoreTemplateName) {
        addGitIgnoreButton.click();
        WebElement targetTemplate = getTemplates().stream()
                .filter(i -> i.getText().equalsIgnoreCase(gitIgnoreTemplateName))
                .findFirst().orElse(null);
        if (targetTemplate == null) {
            throw new IllegalArgumentException("The git ignore template name is incorrect: " + gitIgnoreTemplateName);
        }
        targetTemplate.click();
        return this;
    }

    public CreateRepositoryPage withRandomGitIgnoreTemplate() {
        addGitIgnoreButton.click();
        WebElement currentGitIgnoreTemplate = (WebElement) RandomUtils.getRandomElement(getTemplates());
        currentGitIgnoreTemplate.click();
        verifyGitIgnoreTemplateIsSet(currentGitIgnoreTemplate.getText());
        return this;
    }

    public void create() {
        createRepositoryButton.click();
    }

    private List<WebElement> getTemplates() {
        return templateDropDownItems;
    }

    private CreateRepositoryPage verifyGitIgnoreTemplateIsSet(String templateText) {
        if (!addGitIgnoreButtonSelectionText.getText().contains(templateText)) {
            throw new RuntimeException("Git Ignore template has not been set");
        }
        return this;
    }

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl() + "/new";
    }
}