Feature: Passenger page

  Background:
    Given Navigate to "NZ" Fly365 "stage" site

  Scenario: Verify that the mandatory fields are required at one way
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Choose a trip
    And Click on Next Step
    Then error message appear for each field at fill passenger details

  Scenario: Verify that the first "Read more" link opens on the correct link
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Choose a trip
    And Press on first 'Read more'
    Then 'If you have one name' pop up will be opened

  Scenario: Verify that the second "Read more" link opens on the correct link
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Choose a trip
    And Press on second 'Read more'
    Then 'Correct name format' pop up will be opened

  Scenario: Verify that the "Flights Details" link opens on the correct link
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Choose a trip
    And Press on 'Flights Details'
    Then 'Flights Details' is displayed