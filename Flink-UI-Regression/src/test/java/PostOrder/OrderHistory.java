package PostOrder;

import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class OrderHistory {
    private WebDriver driver;


    @Test
    public void NoOrderTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).NoOrders();
    }
    @Test
    public void OrderHistoryTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("tauto@gmail.com", "111111");
        new CartPage(driver).Cart();
        new CheckoutPage(driver).Checkout("4111 1111 1111 1111", "03 30", "737", "Automation Tester");
        new TrackingPage(driver).order().equals("Order");
        new TrackingPage(driver).close();
        new HomePage(driver).menu();

    }

    @BeforeMethod
    public void setup(){ driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown(){
        DriverFactory.closeAllDrivers();
    }
}
