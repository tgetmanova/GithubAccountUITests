package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.environment.OsContext;
import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "firefox")
public class FireFoxDriverContext implements DriverContext {

    private String driverExecutablePath = "webdriver.gecko.driver";

    public FirefoxDriver getDriver() {
        System.setProperty(this.driverExecutablePath,
                ContextUtils.getAppProperties().getProperty(OsContext.getOsType() + "." + this.driverExecutablePath));
        return new FirefoxDriver();
    }
}
