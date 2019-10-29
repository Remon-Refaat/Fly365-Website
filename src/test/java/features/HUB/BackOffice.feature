Feature: BackOffice Scenarios


  Scenario: Verify that the BackOffice is Opened and redirected successfully
    Given  Navigate to Fly "stage" site
    When login to hub with super admin
    And  Open menu
    And  Open  "BackOffice"
    Then Assert that "backoffice" URL "stage" is opened successfully

