package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositoryPage extends Page {

    private DriverManager driverManager;

    public RepositoryPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public Boolean isAt(String userName, String repositoryName) {
        return driverManager.getDriver().getCurrentUrl()
                .equals(String.format("%s/%s/%s", getBaseUrl(), userName, repositoryName));
    }
}
