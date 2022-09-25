package Address;

import AndroidPages.AddressPage;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class EditAddress {
    private AndroidDriver driver;


    @Test
    public void DeleteAddressTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new AddressPage(driver).addressBook("Lobeckstrasse 30");
        new AddressPage(driver).deleteAddress();


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

