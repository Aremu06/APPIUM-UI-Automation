package AndroidPages;

import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CartPage {
    private AndroidDriver driver;

    public CartPage(AndroidDriver driver) {

        this.driver = driver;
    }

    private By CartPageTitle = AppiumBy.xpath("//android.widget.TextView[@text='Shopping cart']");
    private By checkoutButton = AppiumBy.id("button_basket_base");
    private By backToHome = AppiumBy.id("button_left");
    private By searchBackToHome = AppiumBy.id("button_back");
    private By searchScreen = AppiumBy.id("text_field");
    private By highPDTButton = AppiumBy.xpath("//android.view.View/android.view.View/android.view.View/android.view.View/android.widget.Button");



    public CartPage Cart() {


        new TouchActions(driver).performElementAction().click(checkoutButton);

        try {

            FluentWait wait = new FluentWait(driver);
            wait.withTimeout(Duration.ofSeconds(6));
            wait.pollingEvery(Duration.ofSeconds(3));
            wait.ignoring(NoSuchElementException.class);


            wait.until(ExpectedConditions.visibilityOfElementLocated(highPDTButton));
            driver.findElement(highPDTButton).click();
            System.out.println("High Pdt Exist");
        }
        catch (NoSuchElementException e ) {
            System.out.println("High Pdt Does Not Exist  -  No Such Element");

        }
        catch (TimeoutException e ) {
            System.out.println("High Pdt Does Not Exist  -  TimeOut");

        }

        return this;
    }



    public CartPage backToHomePage() {
        new TouchActions(driver).performElementAction().click(searchScreen).click(searchBackToHome);

        return this;
    }
}




