package automation_test.mortgage_calculator;

import command_providers.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.DriverFactory;

public class BaseClassUITests {
    public WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String testCaseName = String.format("---------Test: %s-----------", this.getClass().getName());
    String endTestCase = String.format("-----------Test End: %s-----------", this.getClass().getName());

    @BeforeClass
    public void addThread() {
        ThreadContext.put("threadName", this.getClass().getName());
        driver = DriverFactory.getInst().getDriver();
    }

    @BeforeMethod
    public void browserInitialization() {
        LOGGER.info(testCaseName);
        String url = "https://www.mortgagecalculator.org/";
        ActOn.browser(driver).openBrowser(url);
    }

    @AfterMethod
    public void quitBrowser() {
        ActOn.browser(driver).close();
        LOGGER.info(endTestCase);
    }
}
