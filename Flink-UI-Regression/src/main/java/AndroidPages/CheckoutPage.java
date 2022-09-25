package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckoutPage {

    private AndroidDriver driver;


    public CheckoutPage(AndroidDriver driver) {

        this.driver = driver;
    }

    private By backToCart = AppiumBy.id("button_left");
    private By DeliveryCommentInput = AppiumBy.xpath("//android.widget.EditText[@index='6']");
    private By discountCodeIcon = AppiumBy.accessibilityId("discount icon");
    private By discountCodeInput = AppiumBy.xpath("//android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.widget.EditText");
   // private By addDiscountButton = AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Button");
    private By addDiscountButton= AppiumBy.xpath("//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.widget.Button");
    private By riderTip = AppiumBy.xpath("//android.view.View/android.view.View[2]/android.widget.Button");
    private By itemValueLabel = AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[3]/android.view.View/android.widget.TextView[2]");
    private By deliveryFeeValueLabel = AppiumBy.xpath("//android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[3]/android.view.View/android.view.View/android.widget.TextView[1]");
    private By totalValueLabel = AppiumBy.xpath("//android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[3]/android.view.View/android.widget.TextView[4]");
    private By proceedToPayButton = AppiumBy.id("button_checkout_buy_now");
    private By continueWithSavedCC = AppiumBy.xpath("//android.widget.Button[@text='CONTINUE']");
    private By creditCardOption = AppiumBy.xpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
    private By cardNumberTextField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'cardNumber')]");
    private By expiryDateTextField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'expiryDate')]");
    private By cvvTextField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'securityCode')]");
    private By cardHolderInputField = AppiumBy.xpath("//android.widget.EditText[contains(@resource-id, 'cardHolder')]");
    private By payButton = AppiumBy.xpath("//*[contains(@resource-id, 'payButton')]");
    private By PayPalOption = AppiumBy.xpath("//android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
    private By changePaymentOption = AppiumBy.id("change_payment_method_button");
    private By openPrivacyPolicyLinks = AppiumBy.linkText("terms and conditions"); // TODO fix element
    private By acceptPrivacyPolicy = AppiumBy.xpath("//android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.Button[2]");
    private By closePrivacyPolicyLinks = AppiumBy.id("close_button");


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
        new TouchActions(driver).performElementAction().click(riderTip).click(riderTip).click(riderTip);
        return this;
    }

    public CheckoutPage DiscountCode(String code) throws InterruptedException {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));
        new TouchActions(driver).performElementAction().click(discountCodeIcon).click(discountCodeInput);
        Thread.sleep(10000);
        new TouchActions(driver).performElementAction().typeAppend(discountCodeInput, code).click(addDiscountButton);

        return this;
    }

    public CheckoutPage riderNote(String comments) {
        new TouchActions(driver).performElementAction()
                .click(DeliveryCommentInput)
                .typeAppend(DeliveryCommentInput, comments);
        return this;

    }
    public CheckoutPage paypal() throws InterruptedException {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Proceed to Pay\"))"));

        new TouchActions(driver).performElementAction().click(proceedToPayButton);
        //.click(changePaymentOption);

        new TouchActions(driver).performElementAction().click(PayPalOption);

        Thread.sleep(10000);
        driver.context("WEBVIEW_chrome");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qa@goflink.com");
        driver.findElement(By.id("password")).sendKeys("flink2020");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(8000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(By.xpath("//*[contains(text(),'Pay Now')]"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[contains(text(),'Pay Now')]")).click();

        return this;
    }

    public CheckoutPage backToCartScreen() {
        new TouchActions(driver).performElementAction().click(backToCart);

        return this;
    }

    public CheckoutPage OrderSummary(){

        new TouchActions(driver).swipeElementIntoView(proceedToPayButton, TouchActions.SwipeDirection.DOWN);

        Validations.verifyThat().element(driver, deliveryFeeValueLabel).exists().perform();
        Validations.verifyThat().element(driver, itemValueLabel).exists().perform();
        Validations.verifyThat().element(driver, totalValueLabel).exists().perform();

        return this;
    }

    public CheckoutPage checkoutPrivacyPolicyLinks() throws InterruptedException {
        new TouchActions(driver).swipeElementIntoView(proceedToPayButton, TouchActions.SwipeDirection.DOWN);

        Thread.sleep(3000);

        new TouchActions(driver).performElementAction().click(OpenPrivacyPolicyLinks).click(acceptPrivacyPolicy).click(closePrivacyPolicyLinks);

        return this;
    }

}

