package com.github.spb.tget.uitests.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Base64;

public class GithubApiUtils {
    public static void getRepos() {
        String encoding = Base64.getEncoder().encodeToString(
                String.format("%s:%s", UserContext.getLogin(), UserContext.getPassword()).getBytes());

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet getRequest = new HttpGet("https://api.github.com/user/repos");
        getRequest.addHeader("accept", "application/json");
        getRequest.setHeader("Authorization", "Basic " + encoding);

        try {
            HttpResponse response = client.execute(getRequest);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
