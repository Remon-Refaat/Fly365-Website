Feature: Sign Up

  Background: Open Fly365 Site
    Given Navigate to URl

  Scenario: Verify that the user can sign up
    And   Open Sign up page
    Then  'Sign Up' page is opened
    And   Fill required data
    And   Click on Create Account
    Then  The user created successfully
    And   The new record set on database


  Scenario: Verify that the user can't sign up without the mandatory fields
    And   Open Sign up page
    Then  'Sign Up' page is opened
    And   Click on Create Account
    Then  The system display validation messages for all mandatory fields


  Scenario Outline: Verify that the user can't sign up with invalid first name
    And  Open Sign up page
    Then 'Sign Up' page is opened
    And  Check validation when enter <invalidName> First Name
    Examples:
      |invalidName|
      | 1234567 |
      | !@#$%^& |
      |حرف عربي |


  Scenario Outline: Verify that the user can't sign up with invalid last name
    And  Open Sign up page
    Then 'Sign Up' page is opened
    And  Check validation when enter <invalidName> Last Name
    Examples:
      |invalidName|
      | 1234567 |
      | !@#$%^& |
      |حرف عربي |


  Scenario Outline: Verify that the user can't sign up with invalid email
    And  Open Sign up page
    Then 'Sign Up' page is opened
    And  Enter First Name
    And  Enter Last Name
    And  Check validation when enter <invalidEmails> Email Address
    Examples:
      | invalidEmails        |
      | plainttext           |
      | omda@@mailinator.com |
      | omda @mailinator.com |
      | omda@mail nantor.com |
      | omda@mailinator      |
      |om@mailinator.com     |


  Scenario Outline: Verify that the user can't sign up with password less than 8 characters
    And  Open Sign up page
    Then 'Sign Up' page is opened
    And  Enter First Name
    And  Enter Last Name
    And  Enter Email
    And  Check validation when enter <invalidPass> Password
    Examples:
    |invalidPass|
    | 123       |
    | 1234567   |
    | 123456789012345678901234567890123456789012345678901|


#  Scenario: Verify that the user can't sign up with the same email twice
#    Given Insert new user in database
#    And Open Sign up page
#    And 'Sign Up' page is opened
#    And Enter First Name
#    And Enter Last Name
#    And Enter Email

