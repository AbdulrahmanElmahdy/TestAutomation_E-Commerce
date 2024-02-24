@smoke
Feature: User add different products to Shopping cart
  Scenario: add product to cart

    Given clicking on selected categorise
      When  clicking on selected product
      And   click on add to cart to selected product
    Then  validate product added to cart
