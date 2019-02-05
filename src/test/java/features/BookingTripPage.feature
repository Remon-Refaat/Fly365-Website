Feature: Booking a Trip

  Background:
    Given Navigate to Fly365 "stage" site

  @Remon
  Scenario: Verify that the user can book a trip
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the trip, after "10" day from today
    And Press on Search Now
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 5   | February | 1985 |

    And Add the following data in the Contact Details
      | Subject    | Value                |
      | Title      | Mr                   |
      | First Name | Remon                |
      | Last Name  | Refaat               |
      | email      | remon@mailinator.com |
    And Click on Next Step
    And Add a valid data for the credit card
    And Add a valid data for the Billing Address
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then Confirmation message is displayed