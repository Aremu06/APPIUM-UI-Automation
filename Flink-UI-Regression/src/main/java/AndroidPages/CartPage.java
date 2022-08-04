package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By CartPageTitle = AppiumBy.xpath("//android.widget.TextView[@text='Shopping cart']");
    private By checkoutButton = AppiumBy.id("button_basket_base");
    private By backToHome = AppiumBy.id("button_left");
    private By searchBackToHome = AppiumBy.id("button_back");
    private By searchScreen = AppiumBy.id("text_field");
    private By highPDTButton = AppiumBy.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");



    public CartPage Cart() {

        Validations.verifyThat().element(driver, CartPageTitle).exists().perform();

        new TouchActions(driver).performElementAction().click(checkoutButton).click(highPDTButton);

        return this;
    }

    public CartPage backToHomePage() {
        new TouchActions(driver).performElementAction().click(searchScreen).click(searchBackToHome);

        return this;
    }
}




