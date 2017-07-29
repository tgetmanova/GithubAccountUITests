package com.github.spb.tget.uitests.maps;

import org.openqa.selenium.By;

public final class ProfileSettingsPageMap {

    private ProfileSettingsPageMap() {
    }

    public static By repositoriesLink() {
        return By.cssSelector("a[href=\"/settings/repositories\"]");
    }
}
