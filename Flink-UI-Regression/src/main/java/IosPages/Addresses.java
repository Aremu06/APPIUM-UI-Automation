package IosPages;

import com.shaft.driver.SHAFT;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class Addresses {
    @Test
    public void testtt() throws SQLException {
        SHAFT.GUI.WebDriver  driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.google.com");

    }
}
