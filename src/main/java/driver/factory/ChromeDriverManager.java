package driver.factory;

import driver.DriverProvider;
import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements IDriverManager {

    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver",
                DriverProvider.getDriverPath(Browsers.Chrome));
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        return driver;
    }
}
