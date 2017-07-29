package com.github.spb.tget.uitests.Utils;

import com.github.spb.tget.uitests.utils.ContextUtils;

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
