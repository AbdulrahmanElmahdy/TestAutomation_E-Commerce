
Feature: User filter by color
  Scenario: select specific categorise

    Given hover on Apparel and click on Shoes
      When filter by color
    Then check shoes filter is success
