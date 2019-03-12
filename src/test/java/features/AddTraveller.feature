Feature: Add Traveller to Login user

  Background:
    Given Navigate to Fly365 "stage" site


  Scenario: Check that Login user can add traveller
    And insert new user at database "m.sayed.89@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    #And user logout
    #And delete new user at database "m.sayed.89@gmail.com"Error Message
    And User press on traveller tab
    And user press on add traveller button

