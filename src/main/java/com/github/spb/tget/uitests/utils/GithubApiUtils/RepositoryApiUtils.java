package com.github.spb.tget.uitests.utils.GithubApiUtils;

import com.github.spb.tget.uitests.utils.RandomUtils;
import com.github.spb.tget.uitests.utils.data.GithubRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static com.github.spb.tget.uitests.utils.UserContext.getLogin;

public class RepositoryApiUtils extends BaseApiUtils {
    protected static final String REPOSITORIES_URL = "https://api.github.com/user/repos";
    protected static final String DELETE_REPOSITORY_URL = "https://api.github.com/repos/{user_login}/{repository_name}";

    public static GithubRepository getRepository(String name) {
        return getRepositories().stream()
                .filter(i -> i.getName().equalsIgnoreCase(name))
                .findAny().orElse(null);
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

    public static List<GithubRepository> getRepositories() {
        HttpGet getRequest = new HttpGet(REPOSITORIES_URL);
        setCommonHeaders(getRequest);
        try {
            HttpResponse response = getClient().execute(getRequest);
            return Arrays.asList(getRepositoriesFromResponse(response.getEntity().getContent()));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static GithubRepository[] getRepositoriesFromResponse(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return gson.fromJson(reader, GithubRepository[].class);
        } catch (Throwable throwable) {
            throw new IllegalStateException(String.format("Cannot read repository items from content: %s", throwable.getMessage()));
        }
    }

    private static GithubRepository getRepositoryFromResponse(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return gson.fromJson(reader, GithubRepository.class);
        } catch (Throwable throwable) {
            throw new IllegalStateException(String.format("Cannot read single repository item from content: %s", throwable.getMessage()));
        }
    }

    private static StringEntity getValidRepositoryEntity() throws IOException {
        GithubRepository repository = new GithubRepository();
        repository.setName(RandomUtils.getRandomString(15));
        return new StringEntity(gson.toJson(repository).toString());
    }
}
