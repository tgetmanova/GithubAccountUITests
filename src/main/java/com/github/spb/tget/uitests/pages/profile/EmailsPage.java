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

    private String emailsSpanCssTemplate = "#settings-emails > li:nth-child(%d)";

    private String emailDeleteButtonCssTemplate = emailsSpanCssTemplate + " button[class*=\"btn-link settings-remove-email \"]";

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

    @Override
    public String getUrl(String... urlParams) {
        return getBaseUrl() + "/settings/emails";
    }

    public void clickDeleteButtonForEmailAddress(String emailAddressToRemove) {
        int emailsCount = getEmailAddressesListItems().size();

        for (int i = 1; i <= emailsCount; i++) {
            if (driverManager.getDriver().findElements(By.cssSelector(
                    String.format(emailsSpanCssTemplate, i))).get(0).getText().contains(emailAddressToRemove)) {
                driverManager.getDriver().findElements(By.cssSelector(
                        String.format(emailDeleteButtonCssTemplate, i))).get(0).click();
                return;
            }
        }
        throw new IllegalStateException(
                "Couldn't find \"Delete\" bin icon for the given email: " + emailAddressToRemove);
    }
}
