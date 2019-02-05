Feature: login to account
  login to a created account

  Scenario: verify that uer can't login with unregistered data
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter unregistered email
    And user enter the right password
    When the user click on login button
    Then user shall see InValid Login Error Message

  Scenario: login into account with wrong password
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter a valid email
    And user enter the wrong password
    When the user click on login button
    Then user shall see InValid Login Error Message

  Scenario: login into account with password less than 8 chars
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter a valid email
    And user enter the password less than 8 chars
    When the user click on login button
    Then user shall see password error message

  Scenario: login into account with password more than 60 chars
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter a valid email
    And user enter the password more than 60 chars
    When the user click on login button
    Then user shall see password error message

  Scenario: login into account with empty password
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter a valid email
    And user enter empty password
    When the user click on login button
    Then user shall see empty password error message

  Scenario: Login into account with empty email
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter an empty email
    And user enter the right password
    When the user click on login button
    Then user shall see email empty error message

  Scenario: Login into account with invalid email formation
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And user enter an invalid email
    And user enter the right password
    When the user click on login button
    Then user shall see email error message

  Scenario: Login into account with correct details
    Given Navigate to Fly365 "stage" site
    And insert new user at database
    And open login page
    And 'Sign In' page is opened
    And user enter a valid email
    And user enter the right password
    When the user click on login button
    Then the user shall be redirect to my booking page
    And user logout
    And delete new user at database

  Scenario: Login into account with correct Upper case email
    Given Navigate to Fly365 "stage" site
    And insert new user at database
    And open login page
    And 'Sign In' page is opened
    And user enter an upper case right email
    And user enter the right password
    When the user click on login button
    Then the user shall be redirect to my booking page
    And user logout
    And delete new user at database

  Scenario: Customer forget password with exist email
    And insert new user at database
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    And enter a valid email at forget password text
    When click on send email button
    Then page shall be redirect to login page
    And delete new user at database

  Scenario: Customer forget password with empty email
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    When click on send email button
    Then user shall see empty email error message at forget password page

  Scenario: Customer forget password with invalid email
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    And enter invalid email formation at email text at forget password page
    When click on send email button
    Then user shall see email error message at forget password page

  Scenario: Customer forget password with Unregistered email
    Given Navigate to Fly365 "stage" site
    And open login page
    And 'Sign In' page is opened
    And press on forget password link
    And enter unregistered email at forget password page
    When click on send email button
    Then user shall see email not registered error message at forget password page
