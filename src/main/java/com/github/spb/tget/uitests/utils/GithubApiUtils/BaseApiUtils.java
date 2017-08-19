package com.github.spb.tget.uitests.utils.GithubApiUtils;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.Base64;

import static com.github.spb.tget.uitests.utils.UserContext.getLogin;
import static com.github.spb.tget.uitests.utils.UserContext.getPassword;

class BaseApiUtils {
    protected static Gson gson = new Gson();

    protected static HttpClient getClient() {
        return HttpClientBuilder.create().build();
    }

    protected static String getAuthenticationEncoded() {
        return Base64.getEncoder().encodeToString(
                String.format("%s:%s", getLogin(), getPassword()).getBytes());
    }

    protected static void setCommonHeaders(HttpRequestBase request) {
        request.setHeader("accept", "application/json");
        request.setHeader("Authorization", "Basic " + getAuthenticationEncoded());
    }
}
