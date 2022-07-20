package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TrackingPage {
    private WebDriver driver;

    public TrackingPage(WebDriver driver){

        this.driver = driver;

    }
    private By activeOrder = AppiumBy.xpath("//android.widget.TextView[@text='Order']");
    private By closeOrderTracking = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"close\"]");
    private By copyOrderID = AppiumBy.xpath("//android.view.View/android.view.View[2]");
    private By Intercom = AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"support\"]");
    private By IntercomNewChatScreen = AppiumBy.id("com.pickery.app.debug:id/new_conversation_button");
    private By IntercomChat = AppiumBy.id("com.pickery.app.debug:id/input_text");
    private By sendChatButton = AppiumBy.id("send_button");
    private By NavigateBackFromInbox = AppiumBy.id("com.pickery.app.debug:id/intercom_toolbar_inbox");
    private By IntercomClose = AppiumBy.id("com.pickery.app.debug:id/intercom_toolbar_close");
    //com.pickery.app.debug:id/send_button







    public TrackingPage order() {
        new TouchActions(driver).performElementAction().click(activeOrder).getText(activeOrder);

        return this;
    }
    public TrackingPage close(){
        new TouchActions(driver).performElementAction().click(closeOrderTracking);

        return this;

    }

    public TrackingPage copyOrder(){
        new TouchActions(driver).performElementAction().click(copyOrderID);
        return this;
    }

    public TrackingPage customerSupport(String message){
        new TouchActions(driver).performElementAction()
                .click(Intercom).click(IntercomNewChatScreen).typeAppend(IntercomChat, message).click(sendChatButton)
                .click(NavigateBackFromInbox)
                .click(IntercomClose);
        return this;
 }
}
