package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.pages.PageFactory;
import com.github.spb.tget.uitests.pages.profile.ProfileSettingsPage;
import org.openqa.selenium.WebDriver;

public class ProfileManager {

    private PageFactory pageFactory;

    private ProfileSettingsPage profileSettingsPage;

    public ProfileManager(WebDriver driver) {
        pageFactory = new PageFactory(driver);

        profileSettingsPage = (ProfileSettingsPage) pageFactory.createPage(ProfileSettingsPage.class);
    }

    public void goToKeysPage(){
        profileSettingsPage.openKeysPage();
    }
}
