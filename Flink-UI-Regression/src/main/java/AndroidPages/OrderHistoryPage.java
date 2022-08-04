package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryPage {
    private WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {

        this.driver = driver;

    }

    private By myOrders = AppiumBy.id("label_title");

    public OrderHistoryPage OrderList() {
        Validations.assertThat().element(driver, myOrders).exists().perform();

        return this;
        }
}