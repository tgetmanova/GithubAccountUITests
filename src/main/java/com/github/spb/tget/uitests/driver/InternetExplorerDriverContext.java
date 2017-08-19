package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.environment.OsContext;
import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "ie")
public class InternetExplorerDriverContext implements DriverContext {

    private String driverExecutableName = "webdriver.ie.driver";

    public InternetExplorerDriver getDriver() {
        System.setProperty(this.driverExecutableName,
                ContextUtils.getAppProperties().getProperty(OsContext.getOsType() + "." + this.driverExecutableName));
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        ieCapabilities.setCapability("requireWindowFocus", true);
        return new InternetExplorerDriver(ieCapabilities);
    }
}
