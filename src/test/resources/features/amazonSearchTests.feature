Feature: Verification of search functionality and adding product to cart


  Scenario: Verification of product search and adding it to cart
    When user opens main page and search for "Snickers"
    Then user can select cheapest product with name "Snickers"
    Then user can add product to the cart