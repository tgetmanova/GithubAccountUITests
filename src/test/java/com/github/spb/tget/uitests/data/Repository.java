package com.github.spb.tget.uitests.data;

public class Repository {

    private String name;

    private String description;

    private String gitIgnoreTemplate;

    private Boolean isReadMeNeeded;

    public String getName() {
        return name;
    }

    public Repository withName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Repository withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGitIgnoreTemplate() {
        return gitIgnoreTemplate;
    }

    public Repository withGitIgnoreTemplate(String gitIgnoreTemplate) {
        this.gitIgnoreTemplate = gitIgnoreTemplate;
        return this;
    }

    public Boolean getReadMeNeeded() {
        return isReadMeNeeded;
    }

    public Repository withReadMeNeeded(Boolean readMeNeeded) {
        isReadMeNeeded = readMeNeeded;
        return this;
    }
}
