Feature: Search for trips and assert on search results

  Background: Open Fly365 site
    Given Navigate to Fly365 "stage" site

  Scenario: Verify that the system display the the correct search results counts for one-way trips
    And Select One Way trip
    And Add airport to the Origin "Auckland International (AKL), New Zealand"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure, after "10" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Scroll to the end of the page
    Then Check count of search results

  Scenario: Verify that the system display the the correct search results data for one-way trips
    And Select One Way trip
    And Add airport to the Origin "Auckland International (AKL), New Zealand"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure, after "10" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Scroll to the end of the page
    Then The system display results as per search criteria

  Scenario: Verify that the system display the the correct search results counts for round-trips
    And Select Round Trip trip
    And Add airport to the Origin "Auckland International (AKL), New Zealand"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure for round trip, after "10" day from today
    And Select the date of the return for round trip, after "25" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Scroll to the end of the page
    Then Check count of search results

  Scenario: Verify that the system display the the correct search results data for round-trips
    And Select Round Trip trip
    And Add airport to the Origin "Auckland International (AKL), New Zealand"
    And Add airport to the Destination "Dubai (DXB), United Arab Emirates"
    And Select the date of the departure for round trip, after "10" day from today
    And Select the date of the return for round trip, after "25" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Scroll to the end of the page
    Then The system display results as per search criteria


  Scenario: Verify that the system display the the correct search results counts for multi-city trips
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                    | Destination                               | Date Period |
      | Auckland International (AKL), New Zealand | Dubai (DXB), United Arab Emirates         | 10          |
      | Dubai (DXB), United Arab Emirates         | Auckland International (AKL), New Zealand | 20          |
      | Auckland International (AKL), New Zealand | Dubai (DXB), United Arab Emirates         | 30          |
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Scroll to the end of the page
    Then Check count of search results

  Scenario: Verify that the system display the the correct search results data for multi-city trips
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                    | Destination                               | Date Period |
      | Auckland International (AKL), New Zealand | Dubai (DXB), United Arab Emirates         | 10          |
      | Dubai (DXB), United Arab Emirates         | Auckland International (AKL), New Zealand | 20          |
      | Auckland International (AKL), New Zealand | Dubai (DXB), United Arab Emirates         | 30          |
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Scroll to the end of the page
    Then The system display results as per search criteria



