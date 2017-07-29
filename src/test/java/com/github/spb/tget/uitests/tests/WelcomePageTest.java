package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.Utils.UserContext;
import com.github.spb.tget.uitests.pages.*;
import com.github.spb.tget.uitests.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

public class WelcomePageTest extends BaseTest {

    private LoginPage loginPage;

    private WelcomePage welcomePage;

    private HomePage homePage;

    private TopPane topPane;

    private CreateRepositoryPage createRepositoryPage;

    private RepositoryPage repositoryPage;

    public WelcomePageTest() {
        welcomePage = new WelcomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        topPane = new TopPane(getDriver());
        createRepositoryPage = new CreateRepositoryPage(getDriver());
        repositoryPage = new RepositoryPage(getDriver());
    }

    @Test
    public void firstAcceptanceTest() {
        homePage.goTo();
        if (!welcomePage.isAt()) {
            homePage.clickSignIn();
            loginPage.withLogin(UserContext.getLogin())
                    .withPassword(UserContext.getPassword())
                    .submit();
        }

        if (!welcomePage.isAt()) {
            loginPage.submit();
        }

        topPane.expandNewDropDown().selectNewRepositoryInDropDown();

        Assert.assertTrue(createRepositoryPage.isAt());

        String expectedRepoName = RandomUtils.getRandomString(10);
        createRepositoryPage.withRepositoryName(expectedRepoName)
                .withRepositoryDescription(RandomUtils.getRandomString(25))
                .withIsReadMeFileNeeded(RandomUtils.getRandomBoolean())
                .withGitIgnoreTemplate("Java")
                .create();
        repositoryPage.isAt(UserContext.getLogin(), expectedRepoName);
    }
}
