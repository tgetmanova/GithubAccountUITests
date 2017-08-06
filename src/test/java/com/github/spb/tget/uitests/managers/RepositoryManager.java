package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.data.Repository;
import com.github.spb.tget.uitests.pages.CreateRepositoryPage;
import com.github.spb.tget.uitests.pages.PageFactory;
import com.github.spb.tget.uitests.pages.repository.RepositoryPage;
import com.github.spb.tget.uitests.pages.TopPane;
import com.github.spb.tget.uitests.utils.RandomUtils;
import com.github.spb.tget.uitests.utils.UserContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RepositoryManager {

    private TopPane topPane;

    private CreateRepositoryPage createRepositoryPage;

    private RepositoryPage repositoryPage;

    private PageFactory pageFactory;

    private String currentRepositoryName;

    public RepositoryManager(WebDriver driver) {
        pageFactory = new PageFactory(driver);

        createRepositoryPage = (CreateRepositoryPage) pageFactory.createPage(CreateRepositoryPage.class);
        repositoryPage = (RepositoryPage) pageFactory.createPage(RepositoryPage.class);

        topPane = new TopPane(driver);
    }

    public void openCreateRepositoryPage() {
        topPane.expandNewDropDown().selectNewRepositoryInDropDown();
    }

    public void createRepository() {
        currentRepositoryName = RandomUtils.getRandomString(15);
        Repository repository = new Repository()
                .withName(currentRepositoryName)
                .withDescription(RandomUtils.getRandomString(25))
                .withReadMeNeeded(RandomUtils.getRandomBoolean());
        createRepository(repository);
    }

    public void createRepository(Repository repository) {
        currentRepositoryName = repository.getName();
        createRepositoryPage.withRepositoryName(currentRepositoryName)
                .withRepositoryDescription(repository.getDescription())
                .withIsReadMeFileNeeded(repository.getReadMeNeeded())
                .withRandomGitIgnoreTemplate()
                .create();
    }

    public void createRepositoryWithTemplate(String template) {
        Repository repository = new Repository()
                .withName(RandomUtils.getRandomString(15))
                .withDescription(RandomUtils.getRandomString(25))
                .withReadMeNeeded(RandomUtils.getRandomBoolean())
                .withGitIgnoreTemplate(template);
        createRepository(repository);
    }

    public void createRepositoryWithTemplate(Repository repository) {
        createRepositoryPage.withRepositoryName(repository.getName())
                .withRepositoryDescription(repository.getDescription())
                .withIsReadMeFileNeeded(repository.getReadMeNeeded())
                .withGitIgnoreTemplate(repository.getGitIgnoreTemplate())
                .create();
    }

    public void verifyIsOnCreateRepositoryPage() {
        Assert.assertTrue(createRepositoryPage.isAt());
    }

    public void verifyIsOnRepositoryPage() {
        if (currentRepositoryName == null || currentRepositoryName.isEmpty()) {
            throw new IllegalStateException("currentRepositoryName has not been specified");
        }
        Assert.assertTrue(repositoryPage.isAt(UserContext.getLogin(), currentRepositoryName));
    }
}
