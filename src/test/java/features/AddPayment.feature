@Sign_Out
Feature: Add Traveller to Login user

  Background:
    Given Navigate to Fly365 "stage" site

  Scenario: Check that Login user can add payment card
    And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "john.smith.fly365@gmail.com"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    And User press on payment tab
    And user press on add payment button
    And Add the following payment card details
      | Card Number      | Holder Name | Expiry Date | CVV |
      | 4000068558002134 | John Smith  | 1234        | 123 |
    And Click Save button
    And Success message is displayed
    And Delete payment card from database
    And user logout
    And delete new user at database "john.smith.fly365@gmail.com"

  Scenario: Check that Login user can delete payment card
    And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "john.smith.fly365@gmail.com"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    And User press on payment tab
    And user press on add payment button
    And Add the following payment card details
      | Card Number        | Holder Name | Expiry Date | CVV |
      | 424242424242424242 | John Smith  | 1234        | 123 |
    And Click Save button
    And Delete new payment from website
    And Success message is displayed
    And user logout
    And delete new user at database "john.smith.fly365@gmail.com"

  Scenario: Check that Login user can default payment card
    And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "john.smith.fly365@gmail.com"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    And User press on payment tab
    And user press on add payment button
    And Add the following payment card details
      | Card Number      | Holder Name | Expiry Date | CVV |
      | 4000068558002134 | John Smith  | 1234        | 123 |
    And Click Save button
    And Add another card
    And Add the following payment card details
      | Card Number        | Holder Name | Expiry Date | CVV |
      | 424242424242424242 | John Smith  | 1234        | 123 |
    And Click Save button
    And Change the default card
    And Success message is displayed
    And Delete payment card from database
    And user logout
    And delete new user at database "john.smith.fly365@gmail.com"





