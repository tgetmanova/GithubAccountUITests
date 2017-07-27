package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.pages.HomePage;
import com.github.spb.tget.uitests.pages.LoginPage;
import com.github.spb.tget.uitests.utils.ContextUtils;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    private LoginPage loginPage;

    public HomePageTest() {
        homePage = new HomePage(this.getDriver());
        loginPage = new LoginPage(this.getDriver());
    }

    @Test
    public void navigateToLoginPageFromHomeAndLogin() {
        homePage.goTo();
        homePage.clickSignIn();
        loginPage.withLogin(ContextUtils.getAppProperties().getProperty("github.login"))
                .withPassword(ContextUtils.getAppProperties().getProperty("github.password"))
                .submit();
    }
}
