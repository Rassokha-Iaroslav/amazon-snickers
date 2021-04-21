package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {

    @When("user opens main page and search for {string}")
    public void userOpensMainPageAndSearch(String searchedString) {
    }

    @Then("user can select cheapest product")
    public void userCanSelectCheapestProduct() {

    }

    @Then("user can add product to the cart")
    public void userCanAddProductToTheCart() {
    }
}
