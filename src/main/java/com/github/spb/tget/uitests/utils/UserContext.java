package com.github.spb.tget.uitests.utils;

public final class UserContext {

    private UserContext() {
    }

    public static String getLogin() {
        return ContextUtils.getAppProperties().getProperty("github.login");
    }

    public static String getPassword() {
        return ContextUtils.getAppProperties().getProperty("github.password");
    }
}
