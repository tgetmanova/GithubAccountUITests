package com.github.spb.tget.uitests.maps;

import org.openqa.selenium.By;

public final class CreateRepositoryPageMap {

    private CreateRepositoryPageMap() {
    }

    public static By repositoryNameField() {
        return By.id("repository_name");
    }

    public static By repositoryDescription() {
        return By.id("repository_description");
    }

    public static By isReadMeFileNeededCheckbox() {
        return By.id("repository_auto_init");
    }

    public static By addGitIgnoreButton() {
        return By.xpath("//*[text() = 'Add .gitignore:']");
    }

    public static By gitIgnoreField() {
        return By.id("context-ignore-filter-field");
    }

    public static By createRepositoryButton() {
        return By.xpath("//button[contains(text(),'Create repository')]");
    }
}
