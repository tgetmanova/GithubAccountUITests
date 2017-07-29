package com.github.spb.tget.uitests.maps;

import org.openqa.selenium.By;

public final class HomePageMap {

    private HomePageMap() {
    }

    public static By signInLink() {
        return By.cssSelector("a[href=\"/login\"]");
    }
}
