
Feature: User switch between currencies US-Euro
  Scenario: switch between US Dollar and Euro

    Given click on currency drop-list and choose Euro
      When  Euro selected, check euro sign
      And   click on currency drop-list and choose US Dollar
    Then  Dollar selected, check dollar sign
