package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "firefox")
public class FireFoxDriverContext implements DriverContext {

    private String driverExecutableName = "webdriver.gecko.driver";

    public FirefoxDriver getDriver() {
        System.setProperty(this.driverExecutableName, ContextUtils.getAppProperties().getProperty(this.driverExecutableName));
        return new FirefoxDriver();
    }
}
