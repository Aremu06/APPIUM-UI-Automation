package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    private AndroidDriver driver;

    public OrderHistoryPage(AndroidDriver driver) {

        this.driver = driver;

    }

    private By myOrders = AppiumBy.id("label_title");

    public OrderHistoryPage OrderList() {
        Validations.assertThat().element(driver, myOrders).exists().perform();

        return this;
        }
}