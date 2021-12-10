package api_test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseClassAPITests {
    public WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String testCaseName = String.format("---------Test: %s-----------", this.getClass().getName());
    String endTestCase = String.format("-----------Test End: %s-----------", this.getClass().getName());

    @BeforeClass
    public void addThread() {
        ThreadContext.put("threadName", this.getClass().getName());
    }
}
