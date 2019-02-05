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
      | Title | First Name | Last Name | Email                |
      | Mr    | Remon      | Refaat    | remon@mailinator.com |

    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Add a valid data for the Billing Address
      | Addres Line 1            | Addres Line 2                | State      | Zip Code |
      | 8287 Lincoln Rd. Fontana | 64 West Evergreen Lane Tracy | California | 90001    |
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then 'Thank you for booking with Fly365' message is displayed