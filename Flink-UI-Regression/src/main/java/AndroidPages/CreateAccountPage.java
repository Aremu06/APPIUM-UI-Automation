package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.stringtemplate.v4.ST;

public class CreateAccountPage {
    private WebDriver driver;


    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
    }

    private By CreateAccountPageTitle = AppiumBy.xpath("//*[contains(@resource-id, 'label_create_account')]");
    private By FirstName              = AppiumBy.xpath("//*[contains(@resource-id, 'text_field_first_name')]");
    private By LastName               = AppiumBy.xpath("//*[contains(@resource-id, 'text_field_last_name')]");
    private By EmailInput             = AppiumBy.xpath("//*[contains(@resource-id, 'text_field_email')]");
    private By PasswordInput          = AppiumBy.xpath("//*[contains(@resource-id, 'text_field_password')]");
    //private By PhoneInput             = AppiumBy.xpath("//*[contains(@resource-id, 'button_register')]");
    private By createAccount             = AppiumBy.id("com.pickery.app.debug:id/button_register");

    public CreateAccountPage Create(String userEmail, String userPassword, String userFirstName, String userLastName, String userPhoneNumber){
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
