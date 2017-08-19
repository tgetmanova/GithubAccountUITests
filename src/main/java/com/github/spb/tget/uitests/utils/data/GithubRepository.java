package com.github.spb.tget.uitests.utils.data;

public class GithubRepository {
    private int id;
    private String name;
    private String full_name;
    private String description;
    private Owner owner;

    private class Owner {
        private String login;
        private int id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
