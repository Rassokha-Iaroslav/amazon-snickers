package pageobjects;

import commons.TestsInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class SearchResultsPage extends BasePage {
    private WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(TestsInitializer.class);
    private static final String FOUND_PRODUCTS = "div[data-component-type='s-search-result']";
    private static final String PRODUCT_PRICE = ".a-price-whole";
    private static final String PRODUCT_NAME = ".a-size-base-plus.a-color-base.a-text-normal";

    @FindBy(how = How.CSS, using = FOUND_PRODUCTS)
    public List<WebElement> foundProducts;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement findCheapestProductFromSearchResult() {
        int cheapestPrise = 0;
        WebElement cheapestProduct = null;
        for (WebElement product : foundProducts) {
            int productPriseInt = 0;
            String productPrise = product.findElement(By.cssSelector(PRODUCT_PRICE)).getText();
            try {
                productPriseInt = (int) NumberFormat.getNumberInstance(Locale.GERMANY).parse(productPrise);
            } catch (ParseException e) {
                log.debug("Product {} prise was not parsed successfully", product.findElement(By.cssSelector(PRODUCT_NAME)).getText());
            }
            if (cheapestPrise == 0 && productPriseInt != 0) {
                cheapestPrise = productPriseInt;
                cheapestProduct = product;
            } else if (cheapestPrise > productPriseInt && productPriseInt != 0) {
                cheapestPrise = productPriseInt;
                cheapestProduct = product;
            }
        }
        return cheapestProduct;
    }

    public ProductPage selectCheapestProduct() {
        WebElement cheapestProduct = findCheapestProductFromSearchResult();
        Actions actions = new Actions(driver);
        actions.moveToElement(cheapestProduct);
        actions.perform();
        cheapestProduct.click();
        return new ProductPage(driver);
    }
}