package IosPages;


import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ios_CartPage {
    private WebDriver driver;



public Ios_CartPage(WebDriver driver) {

    this.driver = driver;

}
    private By checkoutButton      = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Checkout\"]");
    private By proceedToPayButton = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Proceed to Pay\"]");
    private By creditCartOption = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"AdyenDropIn.PaymentMethodListComponent.Kreditkarte.titleLabel\"]\n");
    private By cardNumberTextField = AppiumBy.accessibilityId("AdyenCard.FormCardNumberContainerItem.numberItem.textField");
    private By expiryDateTextField = AppiumBy.accessibilityId("AdyenCard.CardComponent.expiryDateItem.textField");
    private By cvvTextField = AppiumBy.accessibilityId("AdyenCard.CardComponent.securityCodeItem.textField");
    private By payButton    = AppiumBy.accessibilityId("AdyenCard.CardComponent.payButtonItem.button.titleLabel");

    public Ios_CartPage Checkout(String cardNumber , String expiryDate, String cvv) {
        new TouchActions(driver)
                .performElementAction()
                .click(checkoutButton)
                .click(proceedToPayButton)
                .click(creditCartOption)
                .typeAppend(cardNumberTextField,cardNumber)
                .typeAppend(expiryDateTextField,expiryDate)
                .typeAppend(cvvTextField,cvv)
                .click(payButton);

        return this;
    }
}





