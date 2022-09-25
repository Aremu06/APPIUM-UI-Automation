package AndroidPages;


import com.shaft.gui.element.TouchActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class AddressPage {
    private AndroidDriver driver;


    public AddressPage(AndroidDriver driver) {

        this.driver = driver;


    }

    private By selectAddressButton = AppiumBy.id("button_start");
    private By addAddressText = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView//android.view.View//android.widget.EditText");
    private By addressSuggestion = AppiumBy.xpath("//android.view.View[2]/android.view.View[3]");
    private By DeliveryCommentInput = AppiumBy.xpath("//android.view.View[3]/android.widget.ScrollView/android.widget.EditText/android.view.View");
    private By confirmAddress = AppiumBy.xpath("//android.view.View/android.widget.ScrollView/android.view.View/android.widget.Button");
    private By addressLabel = AppiumBy.id("label_address");
    private By addNewAddress = AppiumBy.id("button_new_address");
    private By buttonGuest = AppiumBy.id("button_guest");
    private By selectCountry = AppiumBy.xpath("//android.widget.TextView[@text='Germany']");
    private By selectCountryButton = AppiumBy.id("button_select_country");
    private By selectCity = AppiumBy.xpath("//android.widget.TextView[@text='Berlin']");
    private By selectCityButton = AppiumBy.id("button_select_city");
    private By selectedAddressLabel = AppiumBy.xpath("//android.widget.TextView[@resource-id='com.pickery.app.debug:id/label_address']");
    private By addNewAddressButton = AppiumBy.id("button_new_address");
    private By editAddress = AppiumBy.xpath("//android.view.ViewGroup[2]/android.widget.Button");
    private By deleteButton = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[3]/android.widget.Button");
    private By keepAddressButton = AppiumBy.xpath("//android.view.View/android.view.View[2]/android.widget.Button");
    private By deleteAddressButton = AppiumBy.xpath("//android.view.View/android.view.View[1]/android.widget.Button");
    private By acceptCookies = AppiumBy.xpath("//android.view.View/android.view.View[1]/android.widget.Button");


    public AddressPage pressSelectAddressButton() {
        new TouchActions(driver).performElementAction()
                .click(selectAddressButton);
        return this;
    }

    public AddressPage fillAddress(String address) {
        new TouchActions(driver)
                .performElementAction()
                .typeAppend(addAddressText, address)
                .click(addressSuggestion)
                .click(confirmAddress).click(acceptCookies);

        return this;

    }

    public AddressPage addressBook(String address) {
        new TouchActions(driver).performElementAction().click(addressLabel).click(addNewAddress)
                .typeAppend(addAddressText, address).click(addressSuggestion).click(confirmAddress)
                .click(addressLabel).click(addNewAddress)
                .typeAppend(addAddressText, address).click(addressSuggestion).click(confirmAddress);
        return this;
    }

    public AddressPage guestFlow(String address) {
        new TouchActions(driver).performElementAction()
                .click(buttonGuest)
                .click(selectCountry)
                .click(selectCountryButton)
                .click(selectCity).click(selectCityButton).click(selectedAddressLabel)
                .click(addNewAddress).typeAppend(addAddressText, address)
                .click(addressSuggestion)
                .click(confirmAddress);
        return this;
    }

    public AddressPage deleteAddress() {
        new TouchActions(driver).performElementAction()
                .click(addressLabel)
                .click(editAddress)
                .click(deleteButton).click(keepAddressButton).click(deleteButton)
                .click(deleteAddressButton);
        return this;
    }
}





