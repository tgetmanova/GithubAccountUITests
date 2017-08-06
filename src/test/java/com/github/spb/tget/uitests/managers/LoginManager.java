package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.pages.*;
import com.github.spb.tget.uitests.utils.UserContext;
import org.openqa.selenium.WebDriver;

public class LoginManager {

    private LoginPage loginPage;

    private WelcomePage welcomePage;

    private HomePage homePage;

    private PageFactory pageFactory;

    public LoginManager(WebDriver driver) {
        pageFactory = new PageFactory(driver);

        loginPage = (LoginPage) pageFactory.createPage(LoginPage.class);
        welcomePage = (WelcomePage) pageFactory.createPage(WelcomePage.class);
        homePage = (HomePage) pageFactory.createPage(HomePage.class);
    }

    public void login() {
        login(UserContext.getLogin(), UserContext.getPassword());
    }

    public void login(String login, String password) {
        homePage.goTo();
        if (!welcomePage.isAt()) {
            homePage.clickSignIn();
            loginPage.withLogin(login)
                    .withPassword(password)
                    .submit();
        }

        if (!welcomePage.isAt()) {
            loginPage.submit();
        }
    }
}
