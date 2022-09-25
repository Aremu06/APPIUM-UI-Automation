package SearchAndDiscovery;

import AndroidPages.AddressPage;
import AndroidPages.UserProfilePage;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class UserMenuDropDown {
    private AndroidDriver driver;


    @Test
    public void UserMenuDropDownTest() throws InterruptedException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new UserProfilePage(driver).DropDownMenu();


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
