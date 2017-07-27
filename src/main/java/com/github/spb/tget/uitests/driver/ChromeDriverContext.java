package com.github.spb.tget.uitests.driver;

import com.github.spb.tget.uitests.environment.OsContext;
import com.github.spb.tget.uitests.utils.ContextUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "chrome")
public class ChromeDriverContext implements DriverContext {

    private String driverExecutableName = "webdriver.chrome.driver";

    public ChromeDriver getDriver() {
        System.setProperty(this.driverExecutableName,
                ContextUtils.getAppProperties().getProperty(OsContext.getOsType() + "." + this.driverExecutableName));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        return new ChromeDriver(options);
    }
}
