package com.github.spb.tget.uitests.utils.GithubApiUtils;

import com.github.spb.tget.uitests.utils.data.GithubEmail;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class EmailApiUtils extends BaseApiUtils {
    protected static final String EMAILS_URL = "https://api.github.com/user/emails";

    public static GithubEmail getEmail(String email) {
        return getEmails().stream()
                .filter(i -> i.getEmail().equalsIgnoreCase(email))
                .findAny().orElse(null);
    }

    public static List<GithubEmail> addEmails(List<String> emails) {
        HttpPost createRequest = new HttpPost(EMAILS_URL);
        setCommonHeaders(createRequest);
        try {
            createRequest.setEntity(new StringEntity(gson.toJson(emails.toArray(new String[0]))));
            HttpResponse response = getClient().execute(createRequest);
            return Arrays.asList(getEmailsFromResponse(response.getEntity().getContent()));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public static void deleteEmails(List<String> emails) {
        HttpDeleteWithBody deleteRequest = new HttpDeleteWithBody(EMAILS_URL);
        setCommonHeaders(deleteRequest);
        try {
            deleteRequest.setEntity(new StringEntity(gson.toJson(emails.toArray(new String[0]))));
            getClient().execute(deleteRequest);
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public static List<GithubEmail> getEmails() {
        HttpGet getRequest = new HttpGet(EMAILS_URL);
        setCommonHeaders(getRequest);
        try {
            HttpResponse response = getClient().execute(getRequest);
            return Arrays.asList(getEmailsFromResponse(response.getEntity().getContent()));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private static GithubEmail[] getEmailsFromResponse(InputStream input) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            return gson.fromJson(reader, GithubEmail[].class);
        } catch (Throwable throwable) {
            throw new IllegalStateException(String.format("Cannot read email items from content: %s", throwable.getMessage()));
        }
    }
}
