package AndroidPages;

import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class HomePage{
    private AndroidDriver driver;

    public HomePage(AndroidDriver driver) {

        this.driver = driver;

    }

    private By SearchIcon = AppiumBy.id("com.pickery.app.debug:id/button_open_search");
    private By SearchTextField = AppiumBy.id("com.pickery.app.debug:id/text_field");
    private By plusIcon = AppiumBy.id("button_plus");
    private By backButton = AppiumBy.id("button_back");
    private By shoppingCartButton = AppiumBy.id("button_basket_base");
    private By homeMenuButton = AppiumBy.id("button_menu");
    private By HighPDTToolTip = AppiumBy.xpath("//*[contains(text(),' busy time')]");
    private By categoryLabel = AppiumBy.xpath("//android.widget.LinearLayout[2]/android.widget.TextView");
    private By productImage = AppiumBy.xpath("//android.widget.TextView[@text='Frisch & Fertig']");
    private By productImage2 = AppiumBy.xpath("//android.widget.TextView[@text='Apfel Golden Delicious Kl.I 1 Stk. (Italien)']");
    private By menuFav = AppiumBy.id("menu_fav");
    private By plusButton = AppiumBy.id("button_plus");
    private By minusButton = AppiumBy.id("button_minus");
    private By goBackToCategory = AppiumBy.accessibilityId("Navigate up");
    private By horizontalCategory = AppiumBy.xpath("//*[contains(text(),'Joghurt & Desserts')]");
    private By horizontalCategory1 = AppiumBy.xpath("//android.widget.LinearLayout[2]/android.widget.ImageView"); // TODO fix locator for this element



    public HomePage SearchProducts(String ProductName) {

        new TouchActions(driver)
                .performElementAction().click(categoryLabel).click(SearchIcon)
                .typeAppend(SearchTextField, ProductName)
                .click(plusIcon)
                .click(plusIcon)
                .click(plusIcon)
                .click(shoppingCartButton);


        return this;
    }

    public HomePage Productdetails() throws InterruptedException {
        new TouchActions(driver).performElementAction().click(productImage);

        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Obst & Gemüse\"))")).click();

        new TouchActions(driver).performElementAction().click(productImage2);

        Thread.sleep(5000);

        new TouchActions(driver).performElementAction()
                .click(menuFav).click(plusButton).click(plusButton).click(plusButton)
                .click(minusButton).click(minusButton);

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Empfehlungen\"))"));

        return this;
    }

    public HomePage obstCategory() throws InterruptedException {
        new TouchActions(driver).performElementAction().click(productImage);

        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Obst & Gemüse\"))")).click();

        new TouchActions(driver).performElementAction().click(productImage2);

        Thread.sleep(5000);

        new TouchActions(driver).performElementAction().click(plusButton).click(minusButton)
                .click(goBackToCategory);

        return this;
    }

    public HomePage categoryHorizontalScrolling() throws InterruptedException {
        new TouchActions(driver).performElementAction().click(productImage);

        Thread.sleep(5000);

      //  new TouchActions(driver).swipeElementIntoView(horizontalCategory, TouchActions.SwipeDirection.RIGHT);
          new TouchActions(driver).swipeElementIntoView(horizontalCategory1, TouchActions.SwipeDirection.RIGHT);

        Thread.sleep(5000);

      //  new TouchActions(driver).swipeToElement(horizontalCategory1, horizontalCategory);

        return this;
    }
}
