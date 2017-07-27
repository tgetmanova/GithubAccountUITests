package com.github.spb.tget.uitests.maps;

import org.openqa.selenium.By;

public class HomePageMap {
    public static By signInLink(){
        return By.cssSelector("a[href=\"/login\"]");
    }
}
