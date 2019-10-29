
@My_Booking
Feature: Go to MyBooking page

  Background: Open Fly365 site
    Given Navigate to "NZ" Fly365 "stage" site
    And open login page

  @Sign_Out
  Scenario: Verify that the registered user can go to My Booking page
    And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And user enter email "john.smith.fly365@gmail.com"
    And user enter password "@Test123"
    When the user click on login button
    And Click on My Booking
    Then Check My Booking page opened
    And delete new user at database "john.smith.fly365@gmail.com"

