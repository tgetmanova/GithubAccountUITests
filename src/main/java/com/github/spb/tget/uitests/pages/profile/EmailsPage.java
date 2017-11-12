package com.github.spb.tget.uitests.pages.profile;

import com.github.spb.tget.uitests.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmailsPage extends Page {

    @FindBy(id = "email")
    private WebElement addEmailTextField;

    @FindBy(xpath = "//*[@id=\"new_user_email\"]/dl/dd/button")
    private WebElement addEmailButton;

    @FindBy(id = "js-flash-container")
    private WebElement emailAddedNotificationPane;

    @FindBy(xpath = "//*[@id=\"settings-emails\"]/li")
    private List<WebElement> emailAddressesSpans;

    public EmailsPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailAddress(String email) {
        driverManager.sendInput(addEmailTextField, email);
    }

    public void clickAddEmailAddress() {
        addEmailButton.click();
    }

    public boolean isEmailAddedNotificationDisplayed() {
        return emailAddedNotificationPane.isDisplayed();
    }

    public List<WebElement> getEmailAddressesListItems() {
        return emailAddressesSpans;
    }

    public WebElement locateDeleteEmailButton(String email) {
        // TODO fix not workable location
        return driverManager.getDriver().findElement(By.xpath(String.format(
                "//li[contains(text(),'%s')]/button[@class=\"btn-link settings-remove-email \"]", email)));
    }

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl() + "/settings/emails";
    }
}
