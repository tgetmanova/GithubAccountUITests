package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.pages.HomePage;
import org.junit.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    public HomePageTest() {
        this.homePage = new HomePage(this.getDriver());
    }

    @Test
    public void navigateToHomePage() {
        this.homePage.goTo();
    }
}
