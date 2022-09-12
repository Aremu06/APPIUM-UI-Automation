package SearchAndDiscovery;

import AndroidPages.AddressPage;
import AndroidPages.HomePage;
import com.shaft.driver.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductDetails {

    private AndroidDriver driver;



   @Test
    public void ProductDetailsTest() throws InterruptedException {
       new AddressPage(driver).pressSelectAddressButton().fillAddress("Lobeckstrasse 30");
       new HomePage(driver).Productdetails();

   }

       @Test
       public void ProductDetailsLayerDismissTest () throws InterruptedException {
           new AddressPage(driver).pressSelectAddressButton().fillAddress("Lobeckstrasse 30");
           new HomePage(driver).NavigateUp();

       }
       @BeforeMethod
       public void setup () {
           driver = (AndroidDriver) DriverFactory.getDriver();
       }

       @AfterMethod
       public void teardown () {
           DriverFactory.closeAllDrivers();
       }
   }