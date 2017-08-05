package com.github.spb.tget.uitests.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

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
        execute(() -> element.click());
    }

    public Boolean tryFindElementElseNull(WebElement element){
       try {
           execute(() -> element.isDisplayed(), 3, 1000);
           return true;
       }
       catch (WebDriverException driverException){
           return null;
       }
    }

    private void execute(Runnable runnable){
        execute(runnable, defaultWaitAttemptsCount, defaultWaitIntervalInMillis);
    }

    private void execute(Runnable runnable, int waitAttemptsCount, long waitIntervalInMillis) {
        String message = "";

        for (int i = 0; i < waitAttemptsCount; i++) {
            try {
                runnable.run();
                return;
            } catch (WebDriverException exception) {
                message = exception.getMessage();
            }
            try {
                Thread.sleep(waitIntervalInMillis);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }

        throw new WebDriverException(message);
    }
}
