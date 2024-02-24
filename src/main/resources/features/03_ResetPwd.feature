@smoke
Feature: User reset his/her password successfully
  Scenario: reset password

    Given navigate to login page
      When  click on forget password
      And   insert email
      And   click on recover button
    Then  confirm send to mail message appears