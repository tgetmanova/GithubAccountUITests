package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.utils.ExecutionContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.Collection;

public class DriverManager {

    private WebDriver driver;

    private long defaultWaitIntervalInMillis = 5000;

    private int defaultWaitAttemptsCount = 5;

    public DriverManager(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void click(WebElement element) {
        execute(element::click);
    }

    public void sendInput(WebElement element, String input) {
        execute(() -> element.sendKeys(input));
    }

    public Boolean tryFindElementElseNull(WebElement element) {
        try {
            ExecutionContext.executeForSuccess(element::isDisplayed, 3, 1000);
            return true;
        } catch (WebDriverException driverException) {
            return null;
        }
    }

    public void verifyElementsCollectionIsNotEmpty(Collection<WebElement> collection) {
        ExecutionContext.executeForCondition(() -> !collection.isEmpty(),
                defaultWaitAttemptsCount, defaultWaitIntervalInMillis);
    }

    public void verifyElementExists(WebElement element) {
        ExecutionContext.executeForSuccess(element::isDisplayed, defaultWaitAttemptsCount, defaultWaitIntervalInMillis);
    }

    private void execute(Runnable runnable) {
        ExecutionContext.executeForSuccess(runnable, defaultWaitAttemptsCount, defaultWaitIntervalInMillis);
    }
}
