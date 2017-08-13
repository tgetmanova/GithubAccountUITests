package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.pages.TopPane;
import org.openqa.selenium.WebDriver;

public class TopMenuManager {

    private TopPane topPane;

    public TopMenuManager(WebDriver driver) {
        this.topPane = new TopPane(driver);
    }

    public void openCreateRepositoryPage() {
        topPane.expandNewDropDown().selectNewRepositoryInDropDown();
    }

    public void openProfileSettingsPage() {topPane.expandUserProfileDropDown().selectSettingsInDropDown();}
}
