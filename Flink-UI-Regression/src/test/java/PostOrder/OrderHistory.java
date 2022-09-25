package PostOrder;

import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;


public class OrderHistory {
    private AndroidDriver driver;

    // TODO  remove NoOrders test for logout user
    @Test
    public void NoOrderTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new UserProfilePage(driver).NoOrders();
    }

    @Test
    public void OrderHistoryTest() throws SQLException, InterruptedException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("automation@gmail.com", "123456");
        new CheckoutPage(driver).backToCartScreen();
        new CartPage(driver).backToHomePage();;
        new UserProfilePage(driver).menu();
        new OrderHistoryPage(driver).OrderList();

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
