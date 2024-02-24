
Feature: User add different products to compare list
  Scenario: add product to compare list

    Given click on specific categorise
      When  click on specific product
      And   click on add to compare list icon to selected product
    Then  validate product added to compare list
