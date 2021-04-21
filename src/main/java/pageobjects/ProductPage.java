package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    private WebDriver driver;
    private static final String ADD_TO_CART_BUTTON = "#add-to-cart-button";
    private static final String PRODUCTS_NUMBER_IN_CART = "#nav-cart-count";

    @FindBy(how = How.CSS, using = ADD_TO_CART_BUTTON)
    public WebElement addToCartButton;
    @FindBy(how = How.CSS, using = PRODUCTS_NUMBER_IN_CART)
    public WebElement productsNumberInCartElement;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void addProductToCart() {
        waitVisibility(addToCartButton);
        addToCartButton.click();
    }

    public boolean productWasAddedToCart(int initialProductNumberInCart) {
        return getProductsNumberInCart() > initialProductNumberInCart;
    }

    public int getProductsNumberInCart() {
        return Integer.parseInt(productsNumberInCartElement.getText());
    }
}
