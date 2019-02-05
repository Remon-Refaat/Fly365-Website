Feature: Sign Up

  @Smoke
  Scenario: Verify that the user can sign up
    Given Navigate to Fly365 "stage" site
    And   Open Sign up page
    And   Fill required data
    And   Click on Create Account
    Then  The user created successfully
    And   The new record set on database