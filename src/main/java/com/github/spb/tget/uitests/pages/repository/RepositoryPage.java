package com.github.spb.tget.uitests.pages.repository;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import com.github.spb.tget.uitests.utils.UserContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositoryPage extends Page {

    public RepositoryPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public Boolean isAt(String userName, String repositoryName) {
        return driverManager.getDriver().getCurrentUrl()
                .equals(getUrl(userName, repositoryName));
    }

    public void clickRepositorySettingsLink(String repositoryName){
        repositorySettingsLink(repositoryName).click();
    }

    private WebElement repositorySettingsLink(String repositoryName) {
        return driverManager.getDriver().findElement(
                By.cssSelector(String.format("a[href=\"/%s/%s/settings\"]", UserContext.getLogin(), repositoryName)));
    }

    @Override
    public String getUrl(String... urlParams) {
        int expectedUrlParamsNumber = 2;
        if (urlParams.length != expectedUrlParamsNumber) {
            throw new IllegalArgumentException(expectedUrlParamsNumber + " URL params number expected for the Page: "
                    + this.getClass().getSimpleName());
        }
        return getBaseUrl() + "/" + urlParams[0] + "/" + urlParams[1];
    }
}
