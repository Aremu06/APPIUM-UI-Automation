

import com.shaft.driver.DriverFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.TouchActions;
import com.shaft.validation.Validations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

    public class IOSTest {
        private WebDriver driver;


        @Test
        public void scrollInExpandableLists_verticalScrolling_insideScreen(){
            ElementActions.performTouchAction(driver).tap(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Select your address\"]\n"));
            ElementActions.performElementAction(driver).type(driver,By.xpath("//XCUIElementTypeSearchField[@name=\"Search\"]\n"), "Mittelstraße 20, 13055 Berlin");
           // ElementActions.performTouchAction(driver).hideNativeKeyboard();
            ElementActions.performTouchAction(driver).tap(By.xpath("//XCUIElementTypeCell[@name=\"Mittelstraße 20, 13055 Berlin, Germany\"]\n")) ;
            ElementActions.performTouchAction(driver).tap(By.xpath("//XCUIElementTypeButton[@name=\"Confirm Address\"]\n"));

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

