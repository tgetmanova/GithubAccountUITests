package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.driver.DriverContext;
import com.github.spb.tget.uitests.environment.OsContext;
import com.github.spb.tget.uitests.utils.ContextUtils;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BaseTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return this.driver;
    }

    public BaseTest() {
        String activeProfile = System.getProperty("spring.profiles.active");
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
                ContextUtils.getAppProperties().getProperty(OsContext.getOsType() + "." + activeProfile + ".profile.path"));

        DriverContext driverContext = (DriverContext) applicationContext.getBean("driverContext");
        driver = driverContext.getDriver();
    }

    @After
    public void cleanup() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
