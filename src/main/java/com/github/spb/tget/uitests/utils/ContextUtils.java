package com.github.spb.tget.uitests.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class ContextUtils {
    public static Properties getAppProperties() {
        Properties appProperties = new Properties();

        InputStream str = ContextUtils.class.getResourceAsStream("/application.properties");
        try (Reader reader = new InputStreamReader(str)) {
            appProperties.load(reader);
        } catch (IOException exc) {
        }

        return appProperties;
    }
}
