package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.pages.PageFactory;
import com.github.spb.tget.uitests.pages.profile.AddEmailConfirmationPage;
import com.github.spb.tget.uitests.pages.profile.EmailsPage;
import com.github.spb.tget.uitests.utils.UserContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailManager {
    private PageFactory pageFactory;
    private EmailsPage emailsPage;
    private AddEmailConfirmationPage addEmailConfirmationPage;

    public EmailManager(WebDriver driver) {
        pageFactory = new PageFactory(driver);

        emailsPage = (EmailsPage) pageFactory.createPage(EmailsPage.class);
        addEmailConfirmationPage = (AddEmailConfirmationPage) pageFactory.createPage(AddEmailConfirmationPage.class);
    }

    public void submitNewEmailAddress(String emailAddress) {
        emailsPage.enterEmailAddress(emailAddress);
        emailsPage.clickAddEmailAddress();
        if (!emailsPage.isEmailAddedNotificationDisplayed()) {
            addEmailConfirmationPage.withPassword(UserContext.getPassword()).confirm();
        }
    }

    public void verifyEmailAddressAddedNotificationIsDisplayed() {
        Assert.assertTrue("Notification about email added is not displayed",
                emailsPage.isEmailAddedNotificationDisplayed());
    }

    public void removeEmailAddress(String emailAddressToRemove) {
        // TODO implement
        WebElement elementToClickDelete = getEmailAddressListItem(emailAddressToRemove);
    }

    public void verifyEmailAddressIsInTheList(String emailAddress) {
        Assert.assertNotNull("Failed to find newly added email address in the list",
                getEmailAddressListItem(emailAddress));
    }

    private WebElement getEmailAddressListItem(String emailAddress) {
        return emailsPage.getEmailAddressesListItems()
                .stream()
                .filter(ea -> ea.getText().contains(emailAddress))
                .findFirst()
                .orElse(null);
    }
}
