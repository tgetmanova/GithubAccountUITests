package com.github.spb.tget.uitests.managers;

import com.github.spb.tget.uitests.pages.PageFactory;
import com.github.spb.tget.uitests.pages.profile.AddEmailConfirmationPage;
import com.github.spb.tget.uitests.pages.profile.EmailsPage;
import com.github.spb.tget.uitests.utils.UserContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class EmailManager {
    private PageFactory pageFactory;
    private EmailsPage emailsPage;
    private AddEmailConfirmationPage addEmailConfirmationPage;

    public EmailManager(WebDriver driver) {
        pageFactory = new PageFactory(driver);

        emailsPage = (EmailsPage) pageFactory.createPage(EmailsPage.class);
        addEmailConfirmationPage = (AddEmailConfirmationPage) pageFactory.createPage(AddEmailConfirmationPage.class);
    }

    public void submitNewEmailAddress(String emailAddress){
        emailsPage.enterEmailAddress(emailAddress);
        emailsPage.clickAddEmailAddress();
        if (!emailsPage.isEmailAddedNotificationDisplayed()){
            addEmailConfirmationPage.withPassword(UserContext.getPassword()).confirm();
        }
    }

    public void verifyEmailAddressAddedNotificationIsDisplayed(){
        Assert.assertTrue("Notification about email added is not displayed",
                emailsPage.isEmailAddedNotificationDisplayed());
    }

    public void verifyEmailIsInTheList(String email) {
        throw new NotImplementedException();
    }
}
