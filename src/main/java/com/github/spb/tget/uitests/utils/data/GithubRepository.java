package com.github.spb.tget.uitests.utils.data;

public class GithubRepository {
    private int id;
    private String name;
    private String full_name;
    private Owner owner;

    private class Owner {
        private String login;
        private int id;
        private String avatar_url;
        private String gravatar_id;
        private String url;
        private String html_url;
        private String followers_url;
        private String following_url;
        private String gists_url;
        private String starred_url;
        private String subscriptions_url;
        private String organizations_url;
        private String repos_url;
        private String events_url;
        private String received_events_url;
        private String type;
        private Boolean site_admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
