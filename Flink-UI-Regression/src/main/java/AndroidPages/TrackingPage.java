package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrackingPage {
    private WebDriver driver;

    public TrackingPage(WebDriver driver) {

        this.driver = driver;

    }

    private By activeOrder = AppiumBy.xpath("//android.widget.TextView[@text='Order']");
    private By closeOrderTracking = AppiumBy.xpath("//android.widget.ImageView[@content-desc='close']");
    private By copyOrderID = AppiumBy.xpath("//android.view.View/android.view.View[2]");
    private By Intercom = AppiumBy.xpath("//android.widget.ImageView[@content-desc='support']");
    private By IntercomNewChatScreen = AppiumBy.id("new_conversation_button");
    private By IntercomChat = AppiumBy.id("input_text");
    private By sendChatButton = AppiumBy.id("send_button");
    private By NavigateBackFromInbox = AppiumBy.id("intercom_toolbar_inbox");
    private By IntercomClose = AppiumBy.id("intercom_toolbar_close");
    private By openAddressDetails = AppiumBy.xpath("//android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[2]/android.view.View/android.view.View[1]");
    private By openMapView = AppiumBy.xpath("//android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout[2]");
    private By mapViewButton = AppiumBy.xpath("//android.view.View/android.widget.Button");
    private By editDetailsButton = AppiumBy.xpath("//android.view.View[2]/android.widget.Button");
    private By deliveryNoteTextField= AppiumBy.xpath("//android.view.View/android.widget.ScrollView/android.widget.EditText");
    private By saveButton = AppiumBy.xpath("//android.view.View/android.widget.ScrollView/android.view.View[2]/android.widget.Button");



    public TrackingPage order() {
        new TouchActions(driver).performElementAction().click(activeOrder).getText(activeOrder);

        return this;
    }

    public TrackingPage close() {
        new TouchActions(driver).performElementAction().click(closeOrderTracking);

        return this;

    }

    public TrackingPage copyOrder() {
        new TouchActions(driver).performElementAction().click(copyOrderID);
        return this;
    }

    public TrackingPage customerSupport(String message) {
        new TouchActions(driver).performElementAction()
                .click(Intercom).click(IntercomNewChatScreen).typeAppend(IntercomChat, message).click(sendChatButton)
                .click(NavigateBackFromInbox)
                .click(IntercomClose);
        return this;
    }

    public TrackingPage mapView() {
        new TouchActions(driver).performElementAction()
                .click(openAddressDetails).click(openMapView).click(mapViewButton);
        return this;
    }

    public TrackingPage editDetails(String noteToRider) {

        new TouchActions(driver).performElementAction().click(openAddressDetails);

      //  Validations.verifyThat().element(driver, editDetailsButton).isVisible().perform();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Edit details\"))")).click();

        new TouchActions(driver).performElementAction().typeAppend(deliveryNoteTextField,noteToRider).click(saveButton);
        return this;
    }
}