@smoke
Feature: User select different tags in product page
  Scenario: select different tags in categorise page

    Given click on selected categorise "Digital downloads"
      When  digital downloads is displayed
      And   click on "awesome" tag
    Then  products with tag awesome are displayed

