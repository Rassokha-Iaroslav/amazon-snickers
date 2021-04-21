package commons;

import enums.TestRunTypes;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestConfigReader {
    private static iTestsConfig confProps = ConfigFactory.create(iTestsConfig.class);
    private static Logger log = LoggerFactory.getLogger(TestConfigReader.class);

    private static String capitalizeFirstLetter(String str) {
        if (str.length() > 0) {
            if (str.length() == 1) {
                return str.toUpperCase();
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        } else {
            return null;
        }
    }

    public static String getBrowser() {
        if (System.getProperty("browser") == null) {
            return capitalizeFirstLetter(confProps.getBrowser());
        } else {
            return capitalizeFirstLetter(System.getProperty("browser"));
        }
    }

    public static String getHost() {
        if (System.getProperty("host") == null) {
            return confProps.host();
        } else {
            return System.getProperty("host");
        }
    }

    public static TestRunTypes getTestRunType() {
        String testConfigValue;
        TestRunTypes runType;
        if (System.getProperty("testRunType") == null) {
            testConfigValue = confProps.getTestRunType();
        } else {
            testConfigValue = System.getProperty("testRunType");
        }
        try {
            runType = TestRunTypes.valueOf(testConfigValue.toUpperCase());
        } catch (IllegalArgumentException ex) {
            runType = TestRunTypes.valueOf(confProps.getTestRunType().toUpperCase());
            log.warn("Value of testRunType passed from config or cmd was invalid '{}'. Default value '{}' "
                    + "were taken.", testConfigValue, runType);
        }
        return runType;
    }
}
