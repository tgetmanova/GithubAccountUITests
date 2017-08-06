package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.data.Repository;
import com.github.spb.tget.uitests.managers.LoginManager;
import com.github.spb.tget.uitests.managers.RepositoryManager;
import com.github.spb.tget.uitests.utils.GithubApiUtils;
import com.github.spb.tget.uitests.utils.RandomUtils;
import com.github.spb.tget.uitests.utils.data.GithubRepository;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class CreateRepositoryTest extends BaseTest {

    private LoginManager loginManager;

    private RepositoryManager repositoryManager;

    public CreateRepositoryTest() {
        loginManager = new LoginManager(getDriver());
        repositoryManager = new RepositoryManager(getDriver());
    }

    @Test
    public void createRepositoryShouldRedirectToRepositoryPage() {
        loginManager.login();
        repositoryManager.openCreateRepositoryPage();
        repositoryManager.verifyIsOnCreateRepositoryPage();

        repositoryManager.createRepository();

        repositoryManager.verifyIsOnRepositoryPage();
    }

    @Test
    public void createRepositoryShouldCreateRepositoryWithCorrectSettings() {
        loginManager.login();
        repositoryManager.openCreateRepositoryPage();
        repositoryManager.verifyIsOnCreateRepositoryPage();

        Repository expectedRepository = generateValidRepository();
        repositoryManager.createRepository(expectedRepository);

        GithubRepository actualRepository = GithubApiUtils.getRepository(expectedRepository.getName());
        Assert.assertNotNull("Failed to derived newly created repository by expected name", actualRepository);
        Assert.assertEquals("Description is not as expected",
                expectedRepository.getDescription(),
                actualRepository.getDescription());
    }

    private Repository generateValidRepository() {
        return new Repository()
                .withName(RandomUtils.getRandomString(15))
                .withDescription(RandomUtils.getRandomString(25))
                .withReadMeNeeded(RandomUtils.getRandomBoolean());
    }

    @AfterClass
    public static void CleanupRepositories() {
        GithubApiUtils.getRepositories().stream()
                .map(rep -> rep.getName())
                .forEach(n -> GithubApiUtils.deleteRepository(n));
    }
}
