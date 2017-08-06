package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import com.github.spb.tget.uitests.utils.UserContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositoriesPage extends Page {

    private DriverManager driverManager;

    public RepositoriesPage(WebDriver driver) {
        initElements(driver, this);
        driverManager = new DriverManager(driver);
    }

    public String getUrl() {
        return getBaseUrl() + "/settings/repositories";
    }

    public void clickRepositoryLink(String repositoryName) {
        WebElement targetRepository = repositoriesLinks().stream()
                .filter(i -> i.getText().contains(repositoryName))
                .findFirst().orElse(null);
        if (targetRepository == null){
            throw new IllegalStateException(String.format("Cannot find repository %s in the Repositories list", repositoryName));
        }
        targetRepository.click();
    }

    private List<WebElement> repositoriesLinks() {
        return driverManager.getDriver().findElements(By.xpath(String.format("//a[contains(text(),'%s')]", UserContext.getLogin())));
    }
}
