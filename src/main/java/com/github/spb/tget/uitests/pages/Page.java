package com.github.spb.tget.uitests.pages;

public abstract class Page {
    public String getBaseUrl() {
        return "https://github.com";
    }

    public abstract String getUrl(String... urlParams);
}
