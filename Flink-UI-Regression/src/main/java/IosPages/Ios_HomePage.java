package IosPages;


import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.App;

public class Ios_HomePage {
    private WebDriver driver;



public Ios_HomePage(WebDriver driver) {

    this.driver = driver;

}

    private By SearchIcon         = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"iconSearch\"]");
    private By SearchTextField    = AppiumBy.xpath("//XCUIElementTypeSearchField[@name='Search']");
    private By plusIcon           = AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"iconPlus\"])[1]\n");
    private By shoppingCartButton = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Shopping cart\"]");


    private By allowNotificationButton = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Allow notifications\"]\n");
    private By allowNotificationPermission = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Allow\"]\n");

    public Ios_HomePage SearchProducts(String ProductName) {
        new TouchActions(driver)
                .performElementAction()
                .click(SearchIcon)
                .typeAppend(SearchTextField,ProductName)
                .click(plusIcon)
                .click(plusIcon)
                .click(plusIcon)
                .click(shoppingCartButton);

        return this;
    }
}





