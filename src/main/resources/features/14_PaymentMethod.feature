@smoke
Feature: User select payment
  Scenario: select the payment method and confirm payment info

    Given select check or money order
      And   click continue
      When  payment information tab opened
      And   click continue again
      When  confirm order tab is displayed
      And   click confirm button
    Then  validate the order successfully done and validate order number
