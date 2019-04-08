Feature: Open Account Settings page

  Background: Open Fly365 site
    Given Navigate to Fly365 "stage" site
    And open login page

  @Sign_Out
    Scenario: Verify that the logged in user can open account settings page
      And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
      And user enter email "john.smith.fly365@gmail.com"
      And user enter password "@Test123"
      When the user click on login button
      And Click on Account Settings tab
      Then Account Settings page opened
      And user logout
      And delete new user at database "john.smith.fly365@gmail.com"

  @Sign_Out
    Scenario: Verify that the user can update his information
      And insert new user at database "john.smith.fly365@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
      And user enter email "john.smith.fly365@gmail.com"
      And user enter password "@Test123"
      When the user click on login button
      And Click on Account Settings tab
      Then Update First Name
      Then Check updated First Name
      And user logout
      And delete new user at database "john.smith.fly365@gmail.com"
