package com.github.spb.tget.uitests.utils;

import com.github.spb.tget.uitests.utils.data.GithubRepository;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Base64;

public class GithubApiUtils {

    public static Gson gson = new Gson();

    public static GithubRepository[] getRepositories() {
        String encoding = Base64.getEncoder().encodeToString(
                String.format("%s:%s", UserContext.getLogin(), UserContext.getPassword()).getBytes());

        HttpClient client = HttpClientBuilder.create().build();

        HttpGet getRequest = new HttpGet("https://api.github.com/user/repos");
        getRequest.addHeader("accept", "application/json");
        getRequest.setHeader("Authorization", "Basic " + encoding);

        try {
            HttpResponse response = client.execute(getRequest);
            InputStream input = response.getEntity().getContent();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
                return gson.fromJson(reader, GithubRepository[].class);
            } catch (Throwable throwable) {
                throw new IllegalStateException(String.format("Cannot read single item from content: %s", throwable.getMessage()));
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
