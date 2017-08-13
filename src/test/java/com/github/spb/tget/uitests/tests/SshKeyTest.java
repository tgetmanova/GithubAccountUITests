package com.github.spb.tget.uitests.tests;

import com.github.spb.tget.uitests.managers.KeyManager;
import com.github.spb.tget.uitests.managers.LoginManager;
import com.github.spb.tget.uitests.managers.ProfileManager;
import com.github.spb.tget.uitests.managers.TopMenuManager;
import org.junit.Test;

public class SshKeyTest extends BaseTest {

    private LoginManager loginManger;

    private TopMenuManager topMenuManager;

    private ProfileManager profileManager;

    private KeyManager keyManager;

    public SshKeyTest() {
        loginManger = new LoginManager(getDriver());
        topMenuManager = new TopMenuManager(getDriver());
        keyManager = new KeyManager(getDriver());
        profileManager = new ProfileManager(getDriver());
    }

    @Test
    public void canAddNewSshKey() {
        loginManger.login();
        topMenuManager.openProfileSettingsPage();
        profileManager.goToKeysPage();

        keyManager.AddNewSshKey();
        keyManager.confirm();
    }
}
