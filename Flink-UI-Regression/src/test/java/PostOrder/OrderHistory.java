package PostOrder;

import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;


public class OrderHistory {
    private WebDriver driver;


    @Test
    public void NoOrderTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).NoOrders();
    }

    @Test
    public void OrderHistoryTest() throws SQLException, InterruptedException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("tauto@gmail.com", "111111");
        new CheckoutPage(driver).backToCartScreen();
        new CartPage(driver).backToHomePage();;
        new HomePage(driver).menu();
        new OrderHistoryPage(driver).OrderList();

    }

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.closeAllDrivers();
    }
}
