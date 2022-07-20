import IosPages.Ios_AddressPage;
import IosPages.Ios_CartPage;
import IosPages.Ios_HomePage;
import com.shaft.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Test1 {
    private WebDriver driver;



    @Test
    public void FirstEndToEnd() throws SQLException {

         //new Ios_AddressPage(driver)
           //      .pressSelectAddressButton()
             //    .fillAddress("Mittelstraße 20 13055");

         new Ios_HomePage(driver).SearchProducts("Apfel Golden Delicious Kl.I 1 Stk. (Italien)");
         new Ios_CartPage(driver).Checkout("4111 1111 1111 1111","03 30","737");

    }


    @BeforeMethod
    public void setup() {driver = DriverFactory.getDriver();}

    @AfterMethod
    public void teardown() {DriverFactory.closeAllDrivers();}
}
