package stepdefinitions;

import commons.EnvironmentHelper;
import commons.TestContext;
import commons.iTestsConfig;
import enums.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.MainPage;
import pageobjects.ProductPage;
import pageobjects.SearchResultsPage;

public class AmazonSteps {
    private TestContext testContext;
    BasePage basePage;
    public static iTestsConfig testEnvConfig = EnvironmentHelper.getEnv();

    public AmazonSteps(TestContext testContext) {
        this.testContext = testContext;
        basePage = new BasePage(testContext.getDriver());
    }

    @When("user opens main page and search for {string}")
    public void userOpensMainPageAndSearch(String searchedString) {
        basePage.openPage(testEnvConfig.host());
        MainPage mainPage = new MainPage(testContext.getDriver());
        testContext.setContext(Context.SEARCH_RESULTS_PAGE, mainPage.searchForProduct(searchedString));
    }

    @Then("user can select cheapest product with name {string}")
    public void userCanSelectCheapestProduct(String productName) {
        SearchResultsPage searchResultsPage = (SearchResultsPage) testContext.getContext(Context.SEARCH_RESULTS_PAGE);
        testContext.setContext(Context.PRODUCT_PAGE, searchResultsPage.selectCheapestProductWithName(productName));
    }

    @Then("user can add product to the cart")
    public void userCanAddProductToTheCart() {
        ProductPage productPage = (ProductPage) testContext.getContext(Context.PRODUCT_PAGE);
        int initialProductsNumberInCart = productPage.getProductsNumberInCart();
        productPage.addProductToCart();
        Assert.assertTrue(productPage.productWasAddedToCart(initialProductsNumberInCart));
    }
}
