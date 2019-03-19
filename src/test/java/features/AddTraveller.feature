Feature: Add Traveller to Login user

  Background:
    Given Navigate to Fly365 "stage" site


  Scenario: Check that Login user can add traveller
    And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "john.smith.fly365@gmail.com"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    And User press on traveller tab
    And user press on add traveller button
    And user add traveller
    And user logout
    And Delete new traveller from database
    And delete new user at database "john.smith.fly365@gmail.com"

