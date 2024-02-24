@smoke
Feature: User add different products to Wishlist
  Scenario: add product to wishlist

    Given click on chosen categorise
      When  click on chosen product
      And   click on add to wishlist icon to selected product
    Then  validate product added to wishlist
