package testNg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utilities.ReadConfigFiles;

public class TestNgMavenTest {
    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenTest.class);

    @Test
    public void run() {
        LOGGER.debug("This is debug details message");
        LOGGER.info("This is info message");
        LOGGER.error("This is an error");
        LOGGER.warn("This is a warning");
        LOGGER.fatal("This is dangerous");
    }

    @Test
    public void testPropertyFile() {
        LOGGER.info(ReadConfigFiles.getPropertiesValues("DbUser"));
    }
}
