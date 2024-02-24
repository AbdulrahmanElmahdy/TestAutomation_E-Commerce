@smoke
Feature: User add billing address
  Scenario: fill the billing address for the checkout

    Given update checkout details
      And  validate the first name, last name, and email is filled
      When  select country from the list
      And   insert the city name
      And   insert detailed address
      And   insert the postal code
      And   insert the phone number
      And   click on continue button
    Then  validate the payment method is displayed
