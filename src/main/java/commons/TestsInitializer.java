package commons;

import driver.factory.DriverFactory;
import enums.Browsers;
import enums.TestRunTypes;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestsInitializer {

    private static String log4jConfigPath = "src/main/resources/log4j.properties";
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static final Logger log = LoggerFactory.getLogger(TestsInitializer.class);

    public static WebDriver getDriver() {
        if (threadLocalDriver.get() == null) {
            threadLocalDriver
                    .set(DriverFactory.initDriver(Browsers.valueOf(TestConfigReader.getBrowser())));
            log.debug(String.format("Thread with name '%1$s' and id:'%2$s' created driver",
                    Thread.currentThread().getName(), Thread.currentThread().getId()));

        }
        return threadLocalDriver.get();
    }


    @Before
    public static void setup() {
        setUpLoggingLevel();
        getDriver().manage().window().maximize();
    }

    @After
    public static void cleanup() {
        WebDriver driver = getDriver();
        threadLocalDriver.remove();
        if (driver != null) {
            driver.quit();
        }
    }


    private static void setUpLoggingLevel() {
        PropertyConfigurator.configure(log4jConfigPath);
        if (TestConfigReader.getTestRunType() == TestRunTypes.DEBUG) {
            LogManager.getRootLogger().setLevel(org.apache.log4j.Level.DEBUG);
        }
    }
}
