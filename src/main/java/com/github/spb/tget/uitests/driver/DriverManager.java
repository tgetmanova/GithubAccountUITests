package com.github.spb.tget.uitests.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private WebDriver driver;

    private WebDriverWait wait;

    private long waitInterval = 5000;

    private int waitAttemptsCount = 5;

    public DriverManager(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void click(By elementId){
        execute(() -> driver.findElement(elementId).click());
    }

    private void execute(Runnable runnable) {
        String message = "Initial empty message";

        for (int i = 0; i < waitAttemptsCount; i++) {
            try {
                runnable.run();
                return;
            } catch (WebDriverException exception) {
                message = exception.getMessage();
            }
            try {
                Thread.sleep(waitInterval);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }

        throw new WebDriverException(message);
    }
}
