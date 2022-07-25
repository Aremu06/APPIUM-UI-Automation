package AndroidPages;

import com.shaft.gui.element.TouchActions;
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
    private By backToHome = AppiumBy.id("com.pickery.app.debug:id/button_left");
    private By searchBackToHome = AppiumBy.id("com.pickery.app.debug:id/button_back");
    private By searchScreen = AppiumBy.id("com.pickery.app.debug:id/text_field");


//    /*public  CartPage title() {
//        new TouchActions(driver)
//                .performElementAction()
//                .getText(CartPageTitle)
//                .equalsIgnoreCase("Shopping cart");
//
//        return this;*/
//
//    }

    public CartPage Cart() {
        new TouchActions(driver).performElementAction().click(checkoutButton);

        return this;
    }

    public CartPage backToHomePage() {
        new TouchActions(driver).performElementAction().click(searchScreen).click(searchBackToHome);

        return this;
    }
}




