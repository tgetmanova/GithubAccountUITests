package com.github.spb.tget.uitests.maps.elements;

import org.openqa.selenium.By;

public final class NewDropDown {

    private NewDropDown() {
    }

    public static By newDropDownLink() {
        return By.cssSelector("a[href=\"/new\"]");
    }

    public static By newRepositoryLink() {
        return By.linkText("New repository");
    }
}
