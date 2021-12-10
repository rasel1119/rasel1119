package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // It will not allow to create an object outside from the class
    private DriverFactory() {
        // Empty Constructor
    }

    private static final DriverFactory inst = new DriverFactory();

    public static DriverFactory getInst() {
        return inst;
    }

    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    });

    public WebDriver getDriver() {

        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }

    

}
