package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.ConfirmationWithPasswordPage;
import com.github.spb.tget.uitests.utils.UserContext;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AddEmailConfirmationPage extends ConfirmationWithPasswordPage {

    public AddEmailConfirmationPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public boolean isAt(){
        return driverManager.getDriver().getCurrentUrl()
                .equals(getUrl(UserContext.getLogin()));
    }

    @Override
    public String getUrl(String... urlParams) {
        int expectedUrlParamsNumber = 1;
        if (urlParams.length != expectedUrlParamsNumber) {
            throw new IllegalArgumentException(expectedUrlParamsNumber + " URL params number expected for the Page: "
                    + this.getClass().getSimpleName());
        }
        return getBaseUrl() + "/users/" + urlParams[0] + "/emails";
    }
}
