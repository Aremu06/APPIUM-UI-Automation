package PostOrder;

import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class OrderDetails {

    private AndroidDriver driver;


    @Test
    public void OrderDetailsTest() throws SQLException {
        new AddressPage( driver)
                .pressSelectAddressButton()
                .fillAddress("Mittelstraße 20 13055");

        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("automation@gmail.com", "123456");
        new CartPage(driver).Cart();
        new CheckoutPage(driver).Checkout("4111 1111 1111 1111", "03 30", "737", "Automation Tester");
        new OrderDetailsPage(driver).details();


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

