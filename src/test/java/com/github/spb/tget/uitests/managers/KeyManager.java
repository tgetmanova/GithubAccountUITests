package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.pages.ConfirmationWithPasswordPage;
import com.github.spb.tget.uitests.pages.PageFactory;
import com.github.spb.tget.uitests.pages.profile.KeysPage;
import com.github.spb.tget.uitests.utils.SshKeyUtils;
import com.github.spb.tget.uitests.utils.UserContext;
import org.openqa.selenium.WebDriver;

import static com.github.spb.tget.uitests.utils.RandomUtils.getRandomString;

public class KeyManager {

    private PageFactory pageFactory;

    private KeysPage keysPage;

    private ConfirmationWithPasswordPage confirmationWithPasswordPage;

    public KeyManager(WebDriver driver) {
        pageFactory = new PageFactory(driver);

        keysPage = (KeysPage) pageFactory.createPage(KeysPage.class);
        confirmationWithPasswordPage = (ConfirmationWithPasswordPage) pageFactory
                .createPage(ConfirmationWithPasswordPage.class);
    }

    public void AddNewSshKey() {
        keysPage.expandSshKeyCreationForm()
                .withSshKeyTitle(getRandomString(25))
                .withSshKeyValue(SshKeyUtils.getValidSshKey())
                .submitNewSshKey();
    }

    public void confirm(){
        confirmationWithPasswordPage.withPassword(UserContext.getPassword())
                .confirm();
    }
}
