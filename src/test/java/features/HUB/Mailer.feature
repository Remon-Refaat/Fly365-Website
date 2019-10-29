Feature: Mailer Scenarios

  Scenario: Verify that the Mailer is Opened and redirected successfully
    Given  Navigate to Fly "stage" site
    When login to hub with super admin
    And  Open menu
    And  Open  "Mailer"
    Then Assert that "mailer" URL "stage" is opened successfully