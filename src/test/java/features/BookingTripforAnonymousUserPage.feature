Feature: Booking a Trip for Anonymous User

  Background:
    Given Navigate to Fly365 "stage" site


  Scenario: Verify that the anonymous user can book a One-Way trip
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Select Passengers: "2" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | William    | Smith       | Frank     | 15  | March    | 1982 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2013 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |

    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                |
      | Mr    | Remon      | Refaat    | remon@mailinator.com |

    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Select the passenger name as passport acknowledgment
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then 'Thank you for booking with Fly365' message is displayed


  Scenario: Verify that the anonymous user can book a Round-Trip trip
    And Select Round Trip trip
    And Add airport to the Origin "Cape Town International (CPT), South Africa"
    And Add airport to the Destination "Canberra (CBR), Australia"
    And Select the date of the departure for round trip, after "5" day from today
    And Select the date of the return for round trip, after "15" day from today
    And Select Passengers: "2" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | William    | Smith       | Frank     | 15  | March    | 1982 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |

    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                |
      | Mr    | Remon      | Refaat    | remon@mailinator.com |

    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Select the passenger name as passport acknowledgment
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then 'Thank you for booking with Fly365' message is displayed


  Scenario: Verify that the anonymous user can book a Round-Trip trip
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
    And Select Passengers: "2" adult, "1" child, "1" infant
    And Select "Economy" Class
    And Press on Search Now
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | William    | Smith       | Frank     | 15  | March    | 1982 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |

    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                |
      | Mr    | Remon      | Refaat    | remon@mailinator.com |

    And Click on Next Step
    And Add a valid data for the credit card
      | Card Holder Number | Card Number         | Card Expire Date | Card CVV |
      | John Smith         | 5399 9999 9999 9999 | 0225             | 123      |
    And Select the passenger name as passport acknowledgment
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then 'Thank you for booking with Fly365' message is displayed


    #    And Add a valid data for the Billing Address
#      | Addres Line 1            | Addres Line 2                | State      | Zip Code |
#      | 8287 Lincoln Rd. Fontana | 64 West Evergreen Lane Tracy | California | 90001    |


#  Scenario: Email
#    And get data from database