Feature: Subscription Email

  Background:
    Given Navigate to Fly365 "stage" site


  Scenario: Verify that the user can subscribe his/her email
    And  Add the email address "john.smith.fly365@gmail.com" to Subscription Email field
    When Press on SUBSCRIBE
    Then Successfully validation message is displayed