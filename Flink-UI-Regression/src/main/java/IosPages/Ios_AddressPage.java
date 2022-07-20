package IosPages;


import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ios_AddressPage {
    private WebDriver driver;



public Ios_AddressPage(WebDriver driver) {this.driver = driver;}

    private By selectAddressButton = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Select your address\"]\n");
    private By addAddressText      = AppiumBy.xpath("//XCUIElementTypeSearchField[@name=\"Search\"]\n");
    private By addressSuggestion   = AppiumBy.xpath("//XCUIElementTypeCell[@name=\"Mittelstraße 20, 13055 Berlin, Germany\"]\n");
    private By confirmAddress      = AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Confirm Address\"]\n");





    public Ios_AddressPage pressSelectAddressButton() {


        new TouchActions(driver)
                .tap(selectAddressButton)
                .performElementAction();
        return this;
    }



    public Ios_AddressPage fillAddress(String address) {
        new TouchActions(driver)
                .performElementAction()
                .typeAppend(addAddressText,address)
                .click(addressSuggestion)
                .click(confirmAddress);

        return this;
    }
}





