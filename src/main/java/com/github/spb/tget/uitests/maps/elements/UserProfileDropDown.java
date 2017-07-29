package com.github.spb.tget.uitests.maps.elements;

import org.openqa.selenium.By;

public final class UserProfileDropDown {

    private UserProfileDropDown() {
    }

    public static By profileDropDownLink() {
        return By.cssSelector("img[alt=\"@githubTestUser191\"]");
    }

    public static By settingsLink() {
        return By.cssSelector("a[href=\"/settings/profile\"]");
    }
}
