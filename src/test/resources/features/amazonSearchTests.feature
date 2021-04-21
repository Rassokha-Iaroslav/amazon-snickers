Feature: Verification of search functionality and adding product to cart


  Scenario Outline: Verification of product search and adding it to cart
    When user opens main page and search for "<searchedProduct>"
    Then user can select cheapest product with name "<searchedProduct>"
    Then user can add product to the cart

    Examples:
      | searchedProduct |
      | Snickers        |
      | Twix            |
      | Milky Way       |