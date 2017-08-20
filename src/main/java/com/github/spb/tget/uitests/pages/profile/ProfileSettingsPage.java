package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfileSettingsPage extends Page {

    @FindBy(css = "a[href=\"/settings/repositories\"]")
    private WebElement repositoriesLink;

    @FindBy(css = "a[href=\"/settings/emails\"]")
    private WebElement emailsLink;

    @FindBy(css = "a[href=\"/settings/keys\"]")
    private WebElement keysLink;

    @FindBy(css = "a[href=\"/settings/replies\"]")
    private WebElement repliesLink;

    public ProfileSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void openRepositoriesPage() {
        repositoriesLink.click();
    }

    public void openEmailsPage() {
        emailsLink.click();
    }

    public void openKeysPage(){
        keysLink.click();
    }

    public void openRepliesLink(){
        repliesLink.click();
    }

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl() + "/settings/profile";
    }
}
