package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private WebDriver driver;
    private static final String SEARCH_INPUT_FIELD = "#twotabsearchtextbox";
    private static final String SEARCH_BUTTON = "#nav-search-submit-text";
    private static final String ACCEPT_COOKIE_BUTTON = "#sp-cc-accept";

    @FindBy(how = How.CSS, using = SEARCH_INPUT_FIELD)
    public WebElement searchInputField;

    @FindBy(how = How.CSS, using = SEARCH_BUTTON)
    public WebElement searchButton;

    @FindBy(how = How.CSS, using = ACCEPT_COOKIE_BUTTON)
    public WebElement acceptCookiesButton;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
        acceptCookies();
    }

    private void acceptCookies() {
        if (driver.findElements(By.cssSelector(ACCEPT_COOKIE_BUTTON)).size() > 0) {
            acceptCookiesButton.click();
        }
    }

    public SearchResultsPage searchForProduct(String productName) {
        waitVisibility(searchInputField);
        searchInputField.click();
        searchInputField.clear();
        searchInputField.sendKeys(productName);
        waitVisibility(searchButton);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
