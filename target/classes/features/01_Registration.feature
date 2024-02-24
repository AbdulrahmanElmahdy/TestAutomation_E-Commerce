@smoke
Feature: User could register with valid data
  Scenario: register a new account

    Given user navigate to register page
      When  select gender, fill firstname and lastname
      And   choose birthdate day, month, year
      Then  insert email, password and confirm password
      And   click on register button
    Then  successful register message appears