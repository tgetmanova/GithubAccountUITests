package com.github.spb.tget.uitests.environment;

public class OsContext {

    public static String getOsType() {
        String osType = System.getProperty("os.type");
        return osType != null ? osType : "windows";
    }
}
