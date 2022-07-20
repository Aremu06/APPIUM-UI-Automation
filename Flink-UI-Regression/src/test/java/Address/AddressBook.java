package Address;

import AndroidPages.AddressPage;
import com.shaft.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class AddressBook {
    private WebDriver driver;

    @Test
    public void AddressBookTest() throws SQLException {
        new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
        new AddressPage(driver).addressBook("Lobeckstrasse 30");
    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown(){DriverFactory.closeAllDrivers();}
}
