package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class UserProfilePage {

    private AndroidDriver driver;

    public UserProfilePage(AndroidDriver driver){

        this.driver = driver;

}

    private By homeMenuButton = AppiumBy.id("button_menu");
    private By signOut = AppiumBy.xpath("//android.view.View/android.widget.ScrollView/android.view.View[8]/android.widget.Button");
    private By Orders = AppiumBy.xpath("*//android.view.View/android.widget.ScrollView/android.view.View[2]");
    private By createAccountOrLoginButton = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.Button");
    private By AlreadyHaveAccountLoginLink = AppiumBy.id("button_login");
    private By loginButton = AppiumBy.xpath("//*[contains(@resource-id, 'button_login')]");
    private By emailInput = AppiumBy.xpath("//*[contains(@resource-id, 'text_field_email')]");
    private By passInputField = AppiumBy.xpath("//*[contains(@resource-id, 'text_field_password')]");
    private By ContinueShopping = AppiumBy.id("com.pickery.app.debug:id/button_action");
    private By FAQ = AppiumBy.xpath("//android.widget.TextView[@text='FAQ']");
    private By ContactCustomerService = AppiumBy.xpath("//android.widget.TextView[@text='Contact Customer Service']");
    private By GiveFeedback = AppiumBy.xpath("//android.widget.TextView[@text='Give Feedback']");
    private By PrivacyPolicy = AppiumBy.xpath("//android.widget.TextView[@text='Privacy Policy']");
    private By TermsAndConditions = AppiumBy.xpath("//android.widget.TextView[@text='Terms & Conditions']");
    private By Imprint = AppiumBy.xpath("//android.widget.TextView[@text='Imprint']");




    public UserProfilePage menu() {
        new TouchActions(driver).performElementAction()
                .click(homeMenuButton)
                .click(Orders);
        return this;
    }
// TODO  remove NoOrders test for logout user
    public UserProfilePage NoOrders() {
        new TouchActions(driver).performElementAction()
                .click(homeMenuButton).click(Orders).click(ContinueShopping);
        return this;
    }

    public UserProfilePage signInUser(String UserEmail, String UserPassword){
        new TouchActions(driver).performElementAction().click(homeMenuButton)
                .click(createAccountOrLoginButton)
                .click(AlreadyHaveAccountLoginLink)
                .typeAppend(emailInput, UserEmail).typeAppend(passInputField, UserPassword).click(loginButton);


        return this;
    }

    public UserProfilePage signOutUser(String UserEmail, String UserPassword) throws InterruptedException {
        new TouchActions(driver).performElementAction().click(homeMenuButton)
                .click(createAccountOrLoginButton)
                .click(AlreadyHaveAccountLoginLink)
                .typeAppend(emailInput, UserEmail).typeAppend(passInputField, UserPassword).click(loginButton);

        Thread.sleep(5000);

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Log out\"))")).click();
        //.click(signOut);
        return this;

    } // TODO fix me
    public UserProfilePage DropDownMenu() {
        new TouchActions(driver).performElementAction().click(homeMenuButton);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Imprint\"))"));

        try {
            FluentWait wait = new FluentWait(driver);
            wait.withTimeout(Duration.ofSeconds(5));
            wait.pollingEvery(Duration.ofSeconds(3));
            wait.ignoring(NoSuchElementException.class);

            wait.until(ExpectedConditions.visibilityOfElementLocated(Imprint));
        } catch (NoSuchElementException e) {

        }
            Validations.verifyThat().element(driver, FAQ).exists().perform();
            Validations.verifyThat().element(driver, ContactCustomerService).exists().perform();
            Validations.verifyThat().element(driver, GiveFeedback).exists().perform();
            Validations.verifyThat().element(driver, PrivacyPolicy).exists().perform();
            Validations.verifyThat().element(driver, TermsAndConditions).exists().perform();
            Validations.verifyThat().element(driver, Imprint).exists().perform();

            return this;
        }
}
