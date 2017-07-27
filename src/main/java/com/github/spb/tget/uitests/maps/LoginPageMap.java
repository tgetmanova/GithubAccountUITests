package com.github.spb.tget.uitests.maps;

import org.openqa.selenium.By;

public class LoginPageMap {
    public static By loginField(){
        return By.id("login_field");
    }

    public static By passwordField(){
        return By.id("password");
    }

    public static By signInField(){
        return By.name("commit");
    }
}
