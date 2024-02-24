@smoke
Feature: User log in with valid email and password
  Scenario: login with valid email and password

    Given user navigate to login page
      When user enter valid email and password
      And  user click on login button
    Then  user login succeed
