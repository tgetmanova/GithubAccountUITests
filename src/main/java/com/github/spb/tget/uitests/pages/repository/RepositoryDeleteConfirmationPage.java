package com.github.spb.tget.uitests.pages.repository;

import com.github.spb.tget.uitests.pages.ConfirmationWithPasswordPage;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.PageFactory.initElements;

public class RepositoryDeleteConfirmationPage extends ConfirmationWithPasswordPage {

    public RepositoryDeleteConfirmationPage(WebDriver driver) {
        super(driver);
        initElements(driver, this);
    }

    @Override
    public String getUrl(String... urlParams) {
        int expectedUrlParamsNumber = 2;
        if (urlParams.length != expectedUrlParamsNumber) {
            throw new IllegalArgumentException(expectedUrlParamsNumber + " URL params number expected for the Page: "
                    + this.getClass().getSimpleName());
        }
        return getBaseUrl() + "/" + urlParams[0] + "/" + urlParams[1] + "/settings/delete";
    }
}
