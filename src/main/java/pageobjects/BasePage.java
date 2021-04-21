package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((elementBy)));
    }

    public void waitVisibility(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void openPage(String url) {
        driver.get(url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        log.debug(String.format("Following url were opened: '%s' ", url));
    }

}