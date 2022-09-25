package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class VoucherWalletPage {
    private AndroidDriver driver;

    public VoucherWalletPage(AndroidDriver driver){
        this.driver = driver;
    }
    private By proceedToPayButton = AppiumBy.id("button_checkout_buy_now");
    private By discountCodeIcon = AppiumBy.accessibilityId("discount icon");
    private By userVoucher = AppiumBy.xpath("//android.view.View/android.view.View[1]/android.view.View/android.view.View/android.widget.Button");
    private By removeVoucher= AppiumBy.xpath("//android.view.ViewGroup/androidx.compose.ui.platform.ComposeView[2]/android.view.View/android.widget.TextView[3]");


    public VoucherWalletPage userVoucherEnable() throws InterruptedException {

        new TouchActions(driver).swipeElementIntoView(proceedToPayButton, TouchActions.SwipeDirection.DOWN);
        new TouchActions(driver).performElementAction().click(discountCodeIcon).click(userVoucher);

        Thread.sleep(5000);

        new TouchActions(driver).performElementAction().click(removeVoucher).click(discountCodeIcon).click(userVoucher);
        Thread.sleep(3000);

        return this;
    }
}


