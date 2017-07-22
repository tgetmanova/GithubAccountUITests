package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "firefox")
public class FireFoxDriverContext implements DriverContext {

    public String driverExecutableName() {
        return "webdriver.gecko.driver";
    }

    public FirefoxDriver getDriver() {
        System.setProperty(driverExecutableName(), ContextUtils.getAppProperties().getProperty(driverExecutableName()));
        return new FirefoxDriver();
    }
}
