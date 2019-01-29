Feature: Sign Up

  Scenario: Verify that the user can sign up
    Given Navigate to URl
    And   Open Sign up page
    And   Fill required data
    And   Click on Create Account
    Then  The user created successfully