package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "chrome")
public class ChromeDriverContext implements DriverContext {

    private String driverExecutableName = "webdriver.chrome.driver";

    public ChromeDriver getDriver() {
        System.setProperty(this.driverExecutableName, ContextUtils.getAppProperties().getProperty(this.driverExecutableName));
        return new ChromeDriver();
    }
}
