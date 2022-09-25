package Promotion;

import AndroidPages.*;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Vouchers {
    private AndroidDriver driver;

    @Test
    public void VouchersTest() throws SQLException, InterruptedException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("tauto@gmail.com", "111111");
        new CartPage(driver).Cart();
        new CheckoutPage(driver).DiscountCode("10OFF");


    }
    @Test
    public void userVouchersTest() throws InterruptedException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
        new CartPage(driver).Cart();
        new LoginPage(driver).User("qa@goflink.com", "123456");
        new CartPage(driver).Cart();
        new VoucherWalletPage(driver).userVoucherEnable();
        new CheckoutPage(driver).savedCCPaymentOption();

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