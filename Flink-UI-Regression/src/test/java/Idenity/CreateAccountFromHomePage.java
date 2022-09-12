package Idenity;

import AndroidPages.AddressPage;
import AndroidPages.CreateAccountPage;
import AndroidPages.HomePage;
import AndroidPages.UserProfilePage;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateAccountFromHomePage {
        private AndroidDriver driver;

        @Test
        public void CreateAccountFromHomePage() throws SQLException {
            new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
            new CreateAccountPage()
                    .CreateUserFromHomePage("testting@gmail.com", "123456", "Test", "testing", "123456789");
        }

        @Test
        public void LogInFromHomeScreen(){
            new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
            new UserProfilePage(driver).signInUser("tauto@gmail.com", "111111");

        }
        @Test
        public void LogOutFromHomepage() throws InterruptedException {
            new AddressPage(driver).pressSelectAddressButton().fillAddress("Mittelstraße 20 13055");
            new UserProfilePage(driver).signOutUser("tauto@gmail.com", "111111");


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

