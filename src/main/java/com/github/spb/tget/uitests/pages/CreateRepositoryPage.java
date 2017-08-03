package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.maps.CreateRepositoryPageMap;
import com.github.spb.tget.uitests.utils.RandomUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.github.spb.tget.uitests.maps.CreateRepositoryPageMap.*;

public class CreateRepositoryPage extends Page {

    private DriverManager driverManager;

    private WebElement currentGitIgnoreTemplate;

    public CreateRepositoryPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
    }

    public Boolean isAt() {
        return driverManager.getDriver().getCurrentUrl().equals("https://github.com/new");
    }

    public CreateRepositoryPage withRepositoryName(String repositoryName) {
        driverManager.getDriver().findElement(repositoryNameField()).sendKeys(repositoryName);
        return this;
    }

    public CreateRepositoryPage withRepositoryDescription(String repositoryDescription) {
        driverManager.getDriver().findElement(repositoryDescription()).sendKeys(repositoryDescription);
        return this;
    }

    public CreateRepositoryPage withIsReadMeFileNeeded(Boolean isReadMeFileNeeded) {
        WebElement isReadMeFileNeededCheckbox = driverManager.getDriver().findElement(isReadMeFileNeededCheckbox());
        if (isReadMeFileNeeded && !isReadMeFileNeededCheckbox.isSelected()) {
            isReadMeFileNeededCheckbox.click();
        } else if (!isReadMeFileNeeded && isReadMeFileNeededCheckbox.isSelected()) {
            isReadMeFileNeededCheckbox.click();
        }
        return this;
    }

    public CreateRepositoryPage withGitIgnoreTemplate(String gitIgnoreTemplateName) {
        driverManager.getDriver().findElement(addGitIgnoreButton()).click();
        WebElement targetTemplate = getTemplates().stream()
                .filter(i -> i.getText().equalsIgnoreCase(gitIgnoreTemplateName))
                .findFirst().orElse(null);
        if (targetTemplate == null){
            throw new IllegalArgumentException("The git ignore template name is incorrect: " + gitIgnoreTemplateName);
        }
        targetTemplate.click();
        return this;
    }

    public CreateRepositoryPage withRandomGitIgnoreTemplate() {
        driverManager.getDriver().findElement(addGitIgnoreButton()).click();
        currentGitIgnoreTemplate = (WebElement) RandomUtils.getRandomElement(getTemplates());
        currentGitIgnoreTemplate.click();
        verifyGitIgnoreTemplateIsSet();
        return this;
    }

    public void create() {
        driverManager.getDriver().findElement(createRepositoryButton()).click();
    }

    private List<WebElement> getTemplates() {
        return driverManager.getDriver().findElements(CreateRepositoryPageMap.templateDropDownItems());
    }

    private CreateRepositoryPage verifyGitIgnoreTemplateIsSet() {
        if (!driverManager.getDriver().findElement(addGitIgnoreButtonSelectionText()).getText()
                .contains(currentGitIgnoreTemplate.getText())) {
            throw new RuntimeException("Git Ignore template has not been set");
        }
        return this;
    }
}
