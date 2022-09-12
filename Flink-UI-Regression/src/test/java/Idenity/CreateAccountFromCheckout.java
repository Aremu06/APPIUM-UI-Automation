package Idenity;

import AndroidPages.AddressPage;
import AndroidPages.CartPage;
import AndroidPages.CreateAccountPage;
import AndroidPages.HomePage;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateAccountFromCheckout {
    private AndroidDriver driver;

    @Test
    public void CreatAccountTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new CreateAccountPage()
                .CreateUserFromCheckoutPage("testting@gmail.com", "123456", "Test", "testing", "123456789");
    }

    @BeforeMethod
    public void setup() {
        driver = (AndroidDriver) DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.closeAllDrivers();
    }
}
