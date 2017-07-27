package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.environment.OsContext;
import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "ie")
public class InternetExplorerDriverContext implements DriverContext {

    private String driverExecutableName = "webdriver.ie.driver";

    public InternetExplorerDriver getDriver() {
        System.setProperty(this.driverExecutableName,
                ContextUtils.getAppProperties().getProperty(OsContext.getOsType() + "." + this.driverExecutableName));
        return new InternetExplorerDriver();
    }
}
