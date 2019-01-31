Feature: login to account
  login to a created account using correct data



  Scenario: login into account with unregistered data
    Given Navigate to URl
    And user click on login button on home page
    And user enter unregistered email
    And user enter the right password
    When the user click on login button
    Then user shall see error message

  Scenario: login into account with wrong password
    Given Navigate to URl
    And user click on login button on home page
    And user enter a valid email
    And user enter the wrong password
    When the user click on login button
    Then user shall see error message

  Scenario: login into account with password less than 8 chars
    Given Navigate to URl
    And user click on login button on home page
    And user enter a valid email
    And user enter the password less than 8 chars
    When the user click on login button
    Then user shall see password error message

  Scenario: login into account with password more than 60 chars
    Given Navigate to URl
    And user click on login button on home page
    And user enter a valid email
    And user enter the password more than 60 chars
    When the user click on login button
    Then user shall see password error message


  Scenario: Login into account with invalid email formation
    Given Navigate to URl
    And user click on login button on home page
    And user enter an invalid email
    And user enter the right password
    When the user click on login button
    Then user shall see email error message

  Scenario: Login into account with empty email
    Given Navigate to URl
    And user click on login button on home page
    And user enter an empty email
    And user enter the right password
    When the user click on login button
    Then user shall see email error message


  Scenario: login into account with empty password
    Given Navigate to URl
    And user click on login button on home page
    And user enter a valid email
    And user enter empty password
    When the user click on login button
    Then user shall see password error message


  Scenario: Login into account with correct details
    Given Navigate to URl
    And user click on login button on home page
    And user enter a valid email
    And user enter the right password
    When the user click on login button
    Then the user shall be redirect to my booking page
    And user logout




  Scenario: Login into account with correct Upper case email
    Given Navigate to URl
    And user click on login button on home page
    And user enter an upper case right email
    And user enter the right password
    When the user click on login button
    Then the user shall be redirect to my booking page
    And user logout