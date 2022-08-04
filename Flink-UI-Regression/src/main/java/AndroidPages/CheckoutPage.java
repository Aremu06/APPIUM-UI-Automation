package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage {

    private WebDriver driver;


    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
    }

    private By backToCart = AppiumBy.id("button_left");
    private By commentInput = AppiumBy.xpath("//android.widget.EditText[@index='6']");
    private By discountCodeIcon = AppiumBy.accessibilityId("discount icon");
    private By discountCodeInput = AppiumBy.xpath("//android.widget.EditText/android.view.View");
    private By addDiscountButton = AppiumBy.xpath("//android.view.View/android.view.View/android.view.View[4]/android.widget.Button");
    private By riderTip = AppiumBy.xpath("//android.view.View/android.view.View[2]/android.widget.Button");
    private By subtotalValueLabel = AppiumBy.xpath("//*[contains(@resource-id, 'item_container')]/android.widget.LinearLayout)[1]//*[contains(@resource-id, 'label_value')]");
    private By deliveryFeeValueLabel = AppiumBy.xpath("//*[contains(@resource-id, 'item_container')]/android.widget.LinearLayout)[2]//*[contains(@resource-id, 'label_value')]");
    private By totalValueLabel = AppiumBy.xpath("//*[contains(@resource-id, 'item_container')]/android.widget.LinearLayout)[3]//*[contains(@resource-id, 'label_value')]");
    private By proceedToPayButton = AppiumBy.id("button_checkout_buy_now");
    private By continueWithSavedCC = AppiumBy.xpath("//android.widget.Button[@text='CONTINUE']");
    private By creditCardOption = AppiumBy.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
    private By cardNumberTextField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'cardNumber')]");
    private By expiryDateTextField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'expiryDate')]");
    private By cvvTextField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'securityCode')]");
    private By cardHolderInputField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'cardHolder')]");
    private By payButton = AppiumBy.xpath("//*[contains(@resource-id, 'payButton')]");
    private By PayPalOption = AppiumBy.xpath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");


    public CheckoutPage Checkout(String cardNumber, String expireDate, String cvv, String olderName) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));
        new TouchActions(driver).performElementAction()
                .click(proceedToPayButton)
                .click(creditCardOption)
                .typeAppend(cardNumberTextField, cardNumber)
                .typeAppend(expiryDateTextField, expireDate)
                .typeAppend(cvvTextField, cvv)
                .typeAppend(cardHolderInputField, olderName)
                .click(payButton);

        return this;
    }

    public CheckoutPage savedCCPaymentOption() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));
        new TouchActions(driver).performElementAction()
                .click(proceedToPayButton)
                .click(continueWithSavedCC)
                .typeAppend(cvvTextField, "737")
                .click(payButton);


        return this;
    }

    public CheckoutPage riderTips() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));
        new TouchActions(driver).performElementAction().click(riderTip);
        return this;
    }

    public CheckoutPage DiscountCode(String code) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));
        new TouchActions(driver).performElementAction().
                click(discountCodeIcon).click(discountCodeInput).typeAppend(discountCodeInput, code)
                .click(addDiscountButton);
        return this;
    }

    public CheckoutPage riderNote(String comments) {
        new TouchActions(driver).performElementAction()
                .click(commentInput)
                .typeAppend(commentInput, comments);

        return this;

    }

    public CheckoutPage paypal() throws InterruptedException {  // TODO fix me

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));

        new TouchActions(driver).performElementAction().click(proceedToPayButton).click(PayPalOption);
        driver.manage().wait(5000);
        driver.findElement(AppiumBy.androidUIAutomator("Email address or mobile number")).sendKeys("qa@goflink.com");
        driver.findElement(AppiumBy.androidUIAutomator("Password")).sendKeys("Flink@2022!");
        driver.findElement(AppiumBy.androidUIAutomator("Login")).click();

        return this;

    }

    public CheckoutPage backToCartScreen() {
        new TouchActions(driver).performElementAction().click(backToCart);

        return this;
    }
}

