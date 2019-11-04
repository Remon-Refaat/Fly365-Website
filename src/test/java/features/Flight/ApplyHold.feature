@applyHold
Feature: Apply Hold on Bookings

  Scenario: Verify Hold button is not displayed if departure is less than minimum hours before departure and ticketing
    Given  Navigate to Fly "stage" site
    When login into hub with super admin
    And  Open menu
    And  Open  "Rules"
    And Open Hold Settings
    And Set data for hold rule
      | Min hours before departure | | Min hours before ticketing | | Hold hours | | Hold status | | Exc airlines |
      | 72 | | 72 | | 72 | | Enabled | |  |
    And Set Hold for Store "nz" with Value "30"
    And Navigate to "NZ" Fly365 "stage" site
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "2" day from today
    And Press on Search Now
    Then Hold button is not displayed

  Scenario: Verify Hold button is not displayed when hold is matched but disabled
    Given  Navigate to Fly "stage" site
    When login into hub with super admin
    And  Open menu
    And  Open  "Rules"
    And Open Hold Settings
    And Set data for hold rule
      | Min hours before departure | | Min hours before ticketing | | Hold hours | | Hold status | | Exc airlines |
      | 72 | | 72 | | 72 | | Disabled | |  |
    And Set Hold for Store "nz" with Value "300"
    And Navigate to "NZ" Fly365 "stage" site
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    Then Hold button is not displayed


  Scenario: Verify Hold button is not displayed when hold value is 0
    Given  Navigate to Fly "stage" site
    When login into hub with super admin
    And  Open menu
    And  Open  "Rules"
    And Open Hold Settings
    And Set data for hold rule
      | Min hours before departure | | Min hours before ticketing | | Hold hours | | Hold status | | Exc airlines |
      | 72 | | 72 | | 72 | | Enabled | |  |
    And Set Hold for Store "nz" with Value "0"
    And Navigate to "NZ" Fly365 "stage" site
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    Then Hold button is not displayed

  Scenario: Verify Hold value is displayed correctly in hold button
    Given  Navigate to Fly "stage" site
    When login into hub with super admin
    And  Open menu
    And  Open  "Rules"
    And Open Hold Settings
    And Set data for hold rule
      | Min hours before departure | | Min hours before ticketing | | Hold hours | | Hold status | | Exc airlines |
      | 72 | | 72 | | 72 | | Enabled | |  |
    And Set Hold for Store "nz" with Value "300"
    And Navigate to "NZ" Fly365 "stage" site
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    Then Hold With Value "300" is displayed in hold button

  Scenario: Verify Hold Hours is displayed successfully
    Given  Navigate to Fly "stage" site
    When login into hub with super admin
    And  Open menu
    And  Open  "Rules"
    And Open Hold Settings
    And Set data for hold rule
      | Min hours before departure | | Min hours before ticketing | | Hold hours | | Hold status | | Exc airlines |
      | 72 | | 72 | | 72 | | Enabled | |  |
    And Set Hold for Store "nz" with Value "300"
    And Navigate to "NZ" Fly365 "stage" site
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Click on hold button
    Then Hold hours is displayed with this value "72" correctly in passenger details


  Scenario: Verify Excluded airline will not have hold button
    Given  Navigate to Fly "stage" site
    When login into hub with super admin
    And  Open menu
    And  Open  "Rules"
    And Open Hold Settings
    And Set data for hold rule
      | Min hours before departure | | Min hours before ticketing | | Hold hours | | Hold status | | Exc airlines |
      | 72 | | 72 | | 72 | | Enabled | | ms |
    And Set Hold for Store "nz" with Value "300"
    And Navigate to "NZ" Fly365 "stage" site
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Click on Airline Filter
    And Filter with the following Airline "Egyptair"
    Then Hold button is not displayed
