@New_Tab
Feature: login to account
  login to a created account

  Background:
    Given Navigate to Fly365 "stage" site
    And open login page

  Scenario: Customer forget password with exist email
    And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And press on forget password link
    And enter email at forget password text "john.smith.fly365@gmail.com"
    When click on send email button
    Then page shall be redirect to login page
    And 'Sign In' page is opened
    And delete new user at database "john.smith.fly365@gmail.com"


  Scenario: Customer forget password with empty email
    And press on forget password link
    When click on send email button
    Then user shall see empty email error message at forget password page

  Scenario: Customer forget password with invalid email
    And press on forget password link
    And enter email at forget password text "john.smith.fly365gmail.com"
    When click on send email button
    Then user shall see email error message at forget password page


  Scenario: Customer forget password with Unregistered email
    And press on forget password link
    And enter unregistered email at forget password page
    When click on send email button
    Then user shall see email not registered error message at forget password page

