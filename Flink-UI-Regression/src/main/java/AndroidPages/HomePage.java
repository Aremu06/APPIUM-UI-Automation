package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    private By SearchIcon = AppiumBy.id("button_open_search");
    private By SearchTextField = AppiumBy.id("com.pickery.app.debug:id/text_field");
    private By plusIcon = AppiumBy.id("button_plus");
    private By backButton = AppiumBy.id("com.pickery.app.debug:id/button_back");
    private By shoppingCartButton = AppiumBy.id("com.pickery.app.debug:id/button_basket_base");
    private By homeMenuButton = AppiumBy.id("button_menu");
    private By signOut = AppiumBy.xpath("//android.widget.LinearLayout/android.widget.LinearLayout[7]");
    private By Orders = AppiumBy.xpath("*//android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView");
    private By ContinueShopping = AppiumBy.id("com.pickery.app.debug:id/button_action");
    // private By myOrders = AppiumBy.xpath("android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView");


    // text_field
    public HomePage SearchProducts(String ProductName) {
        new TouchActions(driver)
                .performElementAction().click(SearchIcon)
                .typeAppend(SearchTextField, ProductName)
                .click(plusIcon)
                .click(plusIcon)
                .click(plusIcon)
                .click(shoppingCartButton);

        return this;
    }

    public HomePage menu() {
        new TouchActions(driver).performElementAction()
                .click(homeMenuButton)
                .click(Orders);
        // .click(myOrders);
        return this;
    }

    public HomePage NoOrders() {
        new TouchActions(driver).performElementAction()
                .click(homeMenuButton).click(Orders).click(ContinueShopping);
        return this;
    }

    public HomePage signOutUser() {
        new TouchActions(driver).performElementAction()
                .click(homeMenuButton).click(signOut);
        return this;
    }
}
