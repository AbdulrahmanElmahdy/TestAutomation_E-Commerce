@smoke
Feature: User search for any product
  Scenario: search for a product

    Given write product in search box and click enter
      When  search successfully done
      And   search page is opened
    Then  check that searched product is displayed