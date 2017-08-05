package com.github.spb.tget.uitests.environment;

import java.util.Arrays;

public class OsContext {

    public static String getOsType() {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            return "windows";
        } else if (osName.contains("mac")) {
            return "macos";
        } else if (Arrays.stream(new String[]{"nix", "nux", "aix"}).anyMatch(i -> osName.contains(i))) {
            return "linux";
        }
        throw new IllegalStateException("Cannot identify Operating System type: " + osName);
    }
}
