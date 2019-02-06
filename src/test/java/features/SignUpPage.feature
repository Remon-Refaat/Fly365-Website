@Smoke
Feature: Sign Up

  Background: Open Fly365 Site
    Given Navigate to Fly365 "stage" site

  Scenario: Verify that the user can open sign up
    And Open Sign up page
    Then 'Sign Up' page is opened


  Scenario: Verify that the user can sign up
    And   Open Sign up page
    And   Fill the following required data
      | First Name | Last Name | Email Address               | Password |
      | John       | Smith     | john.smith.fly365@gmail.com | 12345678 |
    And   Click on Create Account
    Then  The user created successfully
    And   The new record set on database


  Scenario: Verify that the user can't sign up without the mandatory fields
    And   Open Sign up page
    And   Click on Create Account
    Then  The system display validation messages for all mandatory fields


  Scenario Outline: Verify that the user can't sign up with invalid first name
    And  Open Sign up page
    And  Fill required data "<First Name>", "<Last Name>", "<Email Address>", "<Password>"
    And  Click on Create Account
    Then The system should display validation message for invalid name
    Examples:
      | First Name | Last Name | Email Address               | Password |
      | 1234       | Smith     | john.smith.fly365@gmail.com | 12345678 |
      | !@#$%^&    | Smith     | john.smith.fly365@gmail.com | 12345678 |
      | حرف عربي   | Smith     | john.smith.fly365@gmail.com | 12345678 |


  Scenario Outline: Verify that the user can't sign up with invalid last name
    And  Open Sign up page
    And  Fill required data "<First Name>", "<Last Name>", "<Email Address>", "<Password>"
    And  Click on Create Account
    Then The system should display validation message for invalid name
    Examples:
      | First Name | Last Name | Email Address               | Password |
      | John       | 1234      | john.smith.fly365@gmail.com | 12345678 |
      | John       | !@#$%^&   | john.smith.fly365@gmail.com | 12345678 |
      | John       | حرف عربي  | john.smith.fly365@gmail.com | 12345678 |


  Scenario Outline: Verify that the user can't sign up with invalid email
    And  Open Sign up page
    And  Fill required data "<First Name>", "<Last Name>", "<Email Address>", "<Password>"
    And  Click on Create Account
    Then The system should display validation message for invalid email
    Examples:
      | First Name | Last Name | Email Address        | Password |
      | John       | Smith     | plainttext           | 12345678 |
      | John       | Smith     | omda @mailinator.com | 12345678 |
      | John       | Smith     | omda@mail nantor.com | 12345678 |
      | John       | Smith     | omda@mailinator      | 12345678 |
      | John       | Smith     | om@mailinator@com    | 12345678 |
      | John       | Smith     | omda@mailnantor..com | 12345678 |


  Scenario Outline: Verify that the user can't sign up with password less than 8 or more than 50 characters
    And  Open Sign up page
    And  Fill required data "<First Name>", "<Last Name>", "<Email Address>", "<Password>"
    Then The system should display validation message for invalid password
    Examples:
      | First Name | Last Name | Email Address               | Password |
      | John       | Smith     | john.smith.fly365@gmail.com | 123      |
      | John       | Smith     | john.smith.fly365@gmail.com | !@##     |
      | John       | Smith     | john.smith.fly365@gmail.com | Hell@oo  |


#  Scenario: Verify that the user can't sign up with the same email twice
#    Given Insert new user in database
#    And Open Sign up page
#    And Enter First Name
#    And Enter Last Name
#    And Enter Email

