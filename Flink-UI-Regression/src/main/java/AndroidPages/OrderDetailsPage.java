package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderDetailsPage {
    private WebDriver driver;

    public OrderDetailsPage(WebDriver driver){

        this.driver = driver;

    }

    private By openOrderDetails = AppiumBy.xpath("//android.widget.LinearLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout");
    private By orderDetails = AppiumBy.xpath("//android.widget.TextView[@text='Order Details']");



    public OrderDetailsPage details() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Cancel order\"))"));

        new TouchActions(driver).performElementAction()
                .click(openOrderDetails)
                .click(orderDetails)
                .getText(orderDetails);
        return this;

  }
}
