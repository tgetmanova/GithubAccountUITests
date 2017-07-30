package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.utils.UserContext;
import com.github.spb.tget.uitests.pages.*;
import com.github.spb.tget.uitests.utils.RandomUtils;
import org.junit.Assert;
import org.junit.Test;

public class WelcomePageTest extends BaseTest{

    private LoginPage loginPage;

    private WelcomePage welcomePage;

    private TopPane topPane;

    private CreateRepositoryPage createRepositoryPage;

    private RepositoryPage repositoryPage;

    private PageFactory pageFactory = new PageFactory(getDriver());

    public WelcomePageTest() {
        pageFactory = new PageFactory(getDriver());

        loginPage = (LoginPage) pageFactory.createPage(LoginPage.class);
        welcomePage = (WelcomePage)pageFactory.createPage(WelcomePage.class);
        createRepositoryPage = (CreateRepositoryPage)pageFactory.createPage(CreateRepositoryPage.class);
        repositoryPage = (RepositoryPage)pageFactory.createPage(RepositoryPage.class);

        topPane = new TopPane(getDriver());
    }

    @Test
    public void firstAcceptanceTest() {
        HomePage homePage = (HomePage) pageFactory.createPage(HomePage.class);
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
