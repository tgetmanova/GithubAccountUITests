package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class EmailsPage extends Page {

    @FindBy(id = "email")
    private WebElement addEmailTextField;

    @FindBy(xpath = "//*[@id=\"new_user_email\"]/dl/dd/button")
    private WebElement addEmailButton;

    @FindBy(id = "js-flash-container")
    private WebElement emailAddedNotificationPane;

    public EmailsPage(WebDriver driver) {
        super(driver);
        initElements(driver, this);
    }

    public void enterEmailAddress(String email){
        driverManager.sendInput(addEmailTextField, email);
    }

    public void clickAddEmailAddress(){
        addEmailButton.click();
    }

    public boolean isEmailAddedNotificationDisplayed(){
        return emailAddedNotificationPane.isDisplayed();
    }

    public String getUrl(){
        return getBaseUrl() + "/settings/emails";
    }

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl() + "/settings/emails";
    }
}
