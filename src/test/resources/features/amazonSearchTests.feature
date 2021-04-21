Feature: Verification of search functionality and adding product to cart


  Scenario: Verification of search and filtering
    When user opens main page and search for "Snickers"
    Then user can select cheapest product
    Then user can add product to the cart