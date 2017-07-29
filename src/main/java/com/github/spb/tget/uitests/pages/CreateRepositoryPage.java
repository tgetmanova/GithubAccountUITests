package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.github.spb.tget.uitests.maps.CreateRepositoryPageMap.*;

public class CreateRepositoryPage extends Page {

    private DriverManager driverManager;

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

    public CreateRepositoryPage withGitIgnoreTemplate(String gitIgnoreTemplate) {
        driverManager.getDriver().findElement(addGitIgnoreButton()).click();
        driverManager.getDriver().findElement(gitIgnoreField()).sendKeys(gitIgnoreTemplate);
        driverManager.getDriver().findElement(gitIgnoreField()).sendKeys(Keys.ENTER);
        return this;
    }

    public void create() {
        driverManager.getDriver().findElement(createRepositoryButton()).click();
    }
}
