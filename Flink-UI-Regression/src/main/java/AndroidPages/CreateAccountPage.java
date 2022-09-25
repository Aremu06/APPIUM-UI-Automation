package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CreateAccountPage {
    private AndroidDriver driver;


    public CreateAccountPage() {
        this.driver = driver;
    }

    private By homeMenuButton = AppiumBy.id("button_menu");
    private By createAccountOrLoginButton = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]/android.widget.Button");
    private By CreateAccountPageTitle = AppiumBy.xpath("//*[contains(@resource-id, 'label_create_account')]");
    private By FirstName = AppiumBy.id("text_field_first_name");
    private By LastName = AppiumBy.id("text_field_last_name");
    private By EmailInput = AppiumBy.id("text_field_email");
    private By PasswordInput = AppiumBy.id("text_field_password");
    //private By PhoneInput             = AppiumBy.xpath("//*[contains(@resource-id, 'button_register')]");
    private By createAccount = AppiumBy.id("com.pickery.app.debug:id/button_register");

    public CreateAccountPage CreateUserFromHomePage(String userEmail, String userPassword, String userFirstName, String userLastName, String userPhoneNumber) {
        new TouchActions(driver)
                .performElementAction().click(homeMenuButton).click(createAccountOrLoginButton)
                .typeAppend(FirstName, userFirstName)
                .typeAppend(LastName, userLastName)
                .typeAppend(EmailInput, userEmail)
                .typeAppend(PasswordInput, userPassword)
                // .typeAppend(PhoneInput, userPhoneNumber)
                .click(createAccount);

        return this;
    }

    public CreateAccountPage CreateUserFromCheckoutPage(String userEmail, String userPassword, String userFirstName, String userLastName, String userPhoneNumber) {
        new TouchActions(driver)
                .performElementAction()
                .typeAppend(FirstName, userFirstName)
                .typeAppend(LastName, userLastName)
                .typeAppend(EmailInput, userEmail)
                .typeAppend(PasswordInput, userPassword)
                // .typeAppend(PhoneInput, userPhoneNumber)
                .click(createAccount);

        return this;

  }
}
