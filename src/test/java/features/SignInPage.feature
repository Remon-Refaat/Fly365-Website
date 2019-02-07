Feature: login to account
  login to a created account

  Background:
    Given Navigate to Fly365 "stage" site

  Scenario: verify that uer can't login with unregistered data
    And open login page
    And 'Sign In' page is opened
    And user enter unregistered email
    And user enter password "@test123"
    When the user click on login button
    Then user shall see InValid Login Error Message

  Scenario: login into account with wrong password
    And open login page
    And insert new user at database "m.sayed.89@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter password "1122334455"
    When the user click on login button
    Then user shall see InValid Login Error Message
    And delete new user at database "m.sayed.89@gmail.com"

    ## covered in sign up form ##
  Scenario: login into account with password less than 8 chars
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter password "111"
    When the user click on login button
    Then user shall see password error message

        ## covered in sign up form ##
  Scenario: login into account with password more than 60 chars
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter password "1111111111111111111111111111111111111111111111111111111111111"
    When the user click on login button
    Then user shall see password error message

  Scenario: login into account with empty password
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter empty password
    When the user click on login button
    Then user shall see empty password error message

  Scenario: Login into account with empty email
    And open login page
    And 'Sign In' page is opened
    And user enter an empty email
    And user enter password "@Test123"
    When the user click on login button
    Then user shall see email empty error message

        ## covered in sign up form ##
  Scenario: Login into account with invalid email formation
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89Gmail.CoM"
    And user enter password "@Test123"
    When the user click on login button
    Then user shall see email error message

  Scenario: Login into account with correct details
    And insert new user at database "m.sayed.89@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    And user logout
    And delete new user at database "m.sayed.89@gmail.com"

  Scenario: Login into account with correct Upper case email
    And insert new user at database "m.sayed.89@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And user enter email "M.saYed.89@Gmail.CoM"
    And user enter password "@Test123"
    When the user click on login button
    Then the user shall be redirect to my booking page
    And user logout
    And delete new user at database "m.sayed.89@gmail.com"

  Scenario: Customer forget password with exist email
    And insert new user at database "m.sayed.89@gmail.com" "$2y$04$E3GLR2vVV0AKfvwm6L0MDeKpVfFw4kR58wb9ohNN.TpGoF6fdpoK."
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    And enter email at forget password text "m.sayed.89@gmail.com"
    When click on send email button
    Then page shall be redirect to login page
    And 'Sign In' page is opened
    And delete new user at database "m.sayed.89@gmail.com"

  Scenario: Customer forget password with empty email
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    When click on send email button
    Then user shall see empty email error message at forget password page

  Scenario: Customer forget password with invalid email
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    And enter email at forget password text "m.sayed.89gmail.com"
    When click on send email button
    Then user shall see email error message at forget password page

  Scenario: Customer forget password with Unregistered email
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    And enter unregistered email at forget password page
    When click on send email button
    Then user shall see email not registered error message at forget password page
