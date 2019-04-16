@Smoke

@Booking_Anonymous
Feature: Booking a Trip for Anonymous User

  Background:
    Given Navigate to Fly365 "stage" site

  Scenario: Verify that the total fare is the same before and after the booking (One-Way trip)
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Get the price of the trip
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |

    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                        | Phone Number|
      | Mr    | John      | Smith      | john.smith.fly365@gmail.com  |0136253637474|
    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Select the passenger name as passport acknowledgment
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then The total fare is the same before and after the booking

  Scenario: Verify that the user can retrieve his booking from Find my Booking (Round Trip)
    And Select Round Trip trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure for round trip, after "5" day from today
    And Select the date of the return for round trip, after "15" day from today
    And Press on Search Now
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |

    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                        | Phone Number|
      | Mr    | John      | Smith      | john.smith.fly365@gmail.com  |0136253637474|
    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Select the passenger name as passport acknowledgment
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    And Get the 'Fly365 Ref' code
    And Click on Find My Booking
    And Add a valid email address "john.smith.fly365@gmail.com"
    And Add a valid Reference 'Fly365 Ref'
    And Press Find Booking
    Then The user can retrieve his booking from Find my Booking