
Feature: User select payment
  Scenario: select the payment method and confirm payment info

    Given select check or money order
      And   click continue
      When  payment information tab opened
      And   click continue again
    Then  confirm order tab is displayed
