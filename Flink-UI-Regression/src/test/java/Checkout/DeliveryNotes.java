package Checkout;

import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeliveryNotes {

    private WebDriver driver;

    @Test
    public void DeliveryNotesTest() {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("tauto@gmail.com", "111111");
        new CartPage(driver).Cart();
        new CheckoutPage(driver).riderNote("find me in berlin office");
}

    @BeforeMethod
    public void setup() { driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown() {DriverFactory.closeAllDrivers();
    }
}
