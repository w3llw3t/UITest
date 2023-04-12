package pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
