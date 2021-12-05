package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class ReadConfigFiles {
    public static final Logger LOGGER = LogManager.getLogger(ReadConfigFiles.class);
    public static String getPropertiesValues(String propName) {
        Properties prop;
        String propValue = null;
        try {
            prop = new LoadConfigFiles().readPropertiesValues();
            propValue = prop.getProperty(propName);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        return propValue;
    }
}
