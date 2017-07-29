package com.github.spb.tget.uitests.pages;

import com.github.spb.tget.uitests.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public class RepositoryPage extends Page {

    private DriverManager driverManager;

    public RepositoryPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
    }

    public Boolean isAt(String userName, String repositoryName) {
        return driverManager.getDriver().getCurrentUrl()
                .equals(String.format("%s/%s/%s", getBaseUrl(), userName, repositoryName));
    }
}
