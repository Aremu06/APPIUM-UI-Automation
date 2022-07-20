import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AndroidSmokeTest {

    private WebDriver driver;


    @Test
    public void SmokeTest() throws SQLException {
        new AddressPage(driver)
                .pressSelectAddressButton()
                .fillAddress("Mittelstraße 20 13055");

        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        //new CartPage(driver).title().equals("Shopping cart");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("tauto@gmail.com", "111111");
        new CartPage(driver).Cart();

        // new CheckoutPage(driver).choosePaymentOptionCC(); --> This steps will reused saved credit card

        new CheckoutPage(driver).Checkout("4111 1111 1111 1111", "03 30", "737", "Automation Tester");
        new TrackingPage(driver).order().equals("Order");

        // new OrderDetailsPage(driver).details();   --> this step will Open Order details page
        new CancellationPage(driver).cancelOrder().equals("Cancel Order");
        new CancellationPage(driver).cancelOrder();


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
