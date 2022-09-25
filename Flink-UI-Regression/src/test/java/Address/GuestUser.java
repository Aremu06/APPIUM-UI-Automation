package Address;

import AndroidPages.AddressPage;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class GuestUser {
    private AndroidDriver driver;


    @Test

    public void GuestUserFlowTest() throws SQLException {
        new AddressPage(driver).guestFlow("LobeckStrasse 30");

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
