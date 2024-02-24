
Feature: User create a successful Order
  Scenario: create a successful Order

    Given click continue to confirm order
      When  click on checkbox to agree terms
      And   click on checkout button
    Then  validate the order successfully done
