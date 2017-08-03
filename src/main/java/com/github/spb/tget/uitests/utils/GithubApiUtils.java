package com.github.spb.tget.uitests.utils;

import com.github.spb.tget.uitests.utils.data.GithubRepository;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Base64;

import static com.github.spb.tget.uitests.utils.UserContext.*;

public class GithubApiUtils {

    private static final String REPOSITORIES_URL = "https://api.github.com/user/repos";

    private static final String DELETE_REPOSITORY_URL = "https://api.github.com/repos/{user_login}/{repository_name}";

    private static Gson gson = new Gson();

    public static GithubRepository getRepository(String name) {
        return Arrays.asList(getRepositories())
                .stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    public static String createRepository() {
        HttpPost createRequest = new HttpPost(REPOSITORIES_URL);
        setCommonHeaders(createRequest);

        try {
            createRequest.setEntity(getValidRepositoryEntity());
            HttpResponse response = getClient().execute(createRequest);
            return getRepositoryFromResponse(response.getEntity().getContent()).getName();

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public static void deleteRepository(String repositoryName) {
        HttpDelete deleteRequest = new HttpDelete(DELETE_REPOSITORY_URL.replace("{user_login}", getLogin())
                .replace("{repository_name}", repositoryName));
        setCommonHeaders(deleteRequest);

        try {
            getClient().execute(deleteRequest);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public static GithubRepository[] getRepositories() {
        HttpGet getRequest = new HttpGet(REPOSITORIES_URL);
        setCommonHeaders(getRequest);

        try {
            HttpResponse response = getClient().execute(getRequest);
            return getRepositoriesFromResponse(response.getEntity().getContent());

        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static HttpClient getClient() {
        return HttpClientBuilder.create().build();
    }

    private static String getAuthenticationEncoded() {
        return Base64.getEncoder().encodeToString(
                String.format("%s:%s", getLogin(), getPassword()).getBytes());
    }

    private static void setCommonHeaders(HttpRequestBase request) {
        request.setHeader("accept", "application/json");
        request.setHeader("Authorization", "Basic " + getAuthenticationEncoded());
    }

    private static GithubRepository[] getRepositoriesFromResponse(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return gson.fromJson(reader, GithubRepository[].class);
        } catch (Throwable throwable) {
            throw new IllegalStateException(String.format("Cannot read single item from content: %s", throwable.getMessage()));
        }
    }

    private static GithubRepository getRepositoryFromResponse(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return gson.fromJson(reader, GithubRepository.class);
        } catch (Throwable throwable) {
            throw new IllegalStateException(String.format("Cannot read single item from content: %s", throwable.getMessage()));
        }
    }

    private static StringEntity getValidRepositoryEntity() throws IOException {
        GithubRepository repository = new GithubRepository();
        repository.setName(RandomUtils.getRandomString(15));
        return new StringEntity(gson.toJson(repository).toString());
    }
}
