package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.driver.DriverManager;
import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class ProfileSettingsPage extends Page {

    private DriverManager driverManager;

    @FindBy(css = "a[href=\"/settings/repositories\"]")
    private WebElement repositoriesLink;

    @FindBy(css = "a[href=\"/settings/emails\"]")
    private WebElement emailsLink;

    @FindBy(css = "a[href=\"/settings/keys\"]")
    private WebElement keysLink;

    @FindBy(css = "a[href=\"/settings/replies\"]")
    private WebElement repliesLink;

    public ProfileSettingsPage(WebDriver driver) {
        driverManager = new DriverManager(driver);
        initElements(driver, this);
    }

    public String getUrl() {
        return getBaseUrl() + "/settings/profile";
    }

    public void openRepositoriesPage() {
        repositoriesLink.click();
    }

    public void openEmailPage() {
        emailsLink.click();
    }

    public void openKeysPage(){
        keysLink.click();
    }

    public void openRepliesLink(){
        repliesLink.click();
    }
}
