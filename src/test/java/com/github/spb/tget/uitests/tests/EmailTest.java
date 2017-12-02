package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.managers.EmailManager;
import com.github.spb.tget.uitests.managers.LoginManager;
import com.github.spb.tget.uitests.managers.ProfileManager;
import com.github.spb.tget.uitests.managers.TopMenuManager;
import com.github.spb.tget.uitests.utils.GithubApiUtils.EmailApiUtils;
import com.github.spb.tget.uitests.utils.RandomUtils;
import org.junit.AfterClass;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class EmailTest extends BaseTest {

    private LoginManager loginManager;
    private ProfileManager profileManager;
    private TopMenuManager topMenuManager;
    private EmailManager emailManager;

    public EmailTest() {
        loginManager = new LoginManager(getDriver());
        profileManager = new ProfileManager(getDriver());
        topMenuManager = new TopMenuManager(getDriver());
        emailManager = new EmailManager(getDriver());
    }

    @Test
    public void mustSeeNotificationAfterNewEmailAddressIsAdded(){
        loginManager.login();
        topMenuManager.openProfileSettingsPage();
        profileManager.gotoToEmailsPage();

        emailManager.submitNewEmailAddress(RandomUtils.getRandomEmailAddress());

        emailManager.verifyEmailAddressAddedNotificationIsDisplayed();
    }

    @Test
    public void mustSeeNewlyAddedEmailAddressInTheEmailsList(){
        loginManager.login();
        topMenuManager.openProfileSettingsPage();
        profileManager.gotoToEmailsPage();

        String email = RandomUtils.getRandomEmailAddress();
        emailManager.submitNewEmailAddress(email);

        emailManager.verifyEmailAddressIsInTheList(email);
    }

    @AfterClass
    public static void cleanupEmails(){
        List<String> emailsToCleanup = EmailApiUtils.getEmails()
                .stream()
                .filter(e -> !e.getVerified())
                .map(e -> e.getEmail())
                .collect(Collectors.toList());
        EmailApiUtils.deleteEmails(emailsToCleanup);
    }
}
