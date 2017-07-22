package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.driver.DriverContext;
import com.github.spb.tget.uitests.utils.ContextUtils;

import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SimpleTest {

    private DriverContext driverContext;

    @Test
    public void test1() {
        String activeProfile = System.getProperty("spring.profiles.active");
        ApplicationContext ctx = new FileSystemXmlApplicationContext(
                ContextUtils.getAppProperties().getProperty(activeProfile + ".profile.path"));

        driverContext = (DriverContext) ctx.getBean("driverContext");
        WebDriver driver = driverContext.getDriver();
        driver.navigate().to("https://github.com");
    }
}
