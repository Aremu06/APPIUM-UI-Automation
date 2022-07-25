package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CancellationPage {
    private WebDriver driver;

    public CancellationPage(WebDriver driver) {

        this.driver = driver;

    }

    private By orderCancellationButton = AppiumBy.xpath("//android.view.View/android.view.View/android.widget.Button");
    private By cancellationSheet = AppiumBy.xpath("//android.widget.TextView[@text='Cancel Order']");
    private By cancellationReasons = AppiumBy.xpath("//android.view.View[1]/android.widget.RadioButton");
    private By finalCancellationButton = AppiumBy.xpath("//android.view.View/android.view.View[2]/android.view.View[6]/android.widget.Button");


    public CancellationPage cancelOrder() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Cancel order\"))"));
        new TouchActions(driver).performElementAction()
                .click(orderCancellationButton)
                .click(cancellationSheet)
                .click(cancellationReasons)
                .click(finalCancellationButton);

        return this;
    }
}