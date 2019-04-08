Feature: Booking a Trip for Anonymous User

  Background:
    Given Navigate to Fly365 "stage" site

  Scenario: Verify that the mandatory fields are required at one way
    And Select One Way trip
    And Press on Search Now
    Then error message appear for each field at fill passenger details

  Scenario: Verify that the anonymous user can book a One-Way trip
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Press on Search Now
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
    And Add the following data in the Contact Details
      | Title | First Name | Last Name | Email                        | Phone Number|
      | Mr    | John      | Smith      | john.smith.fly365@gmail.com  |0136253637474|
    And Click on Next Step
    And Press on Pay button
    Then error message appear for each field at fill passenger details on payment page

  Scenario: Verify that the anonymous user can book a One-Way trip
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
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
    Then 'Thank you for booking with Fly365' message is displayed

  Scenario: Verify that the Booking Confirmation email contains 'Tax Invoice' and 'Booking Confirmation' pdf (One-Way trip)
    And Delete all messages in the Inbox
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
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
    Then Booking Confirmation email contains 'Tax Invoice' and 'Booking Confirmation' pdf

  Scenario: Verify that the user can retrieve his booking from Find my Booking (One-Way trip)
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
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

  @delete_pdf
  Scenario: Verify that the the Tax Invoice pdf contains the correct data (One-Way trip)
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
    And Select Passengers: "2" adult, "2" child, "2" infant
    And Select "Economy" Class
    And Press on Search Now
    And Press on 'Stops' Filter
    And Select 'One Stop' trips
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | Michael    | William     | Smith     | 15  | February | 1985 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Peter      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |
      | Mr    | John       | Peter       | Frank     | 15  | January  | 2019 |
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
    And Get the different values of the Flight
    And Download the tax invoice pdf
    Then The tax invoice pdf contains the correct data for One Way

  @delete_pdf
  Scenario: Verify that the the Booking Confirmation pdf contains the correct data (One-Way trip)
    And Select One Way trip
    And Add airport to the Origin "Auckland International (AKL), New Zealand"
    And Add airport to the Destination "Canberra (CBR), Australia"
    And Select the date of the departure, after "5" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Press on Search Now
    And Press on 'Stops' Filter
    And Select 'One Stop' trips
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |
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
    And Get the different values of the Flight
    And Download the booking confirmation pdf
    Then The booking confirmation pdf contains the correct data for One Way

  Scenario: Verify that the Booking Confirmation email is sent successfully (One-Way trip)
    And Delete all messages in the Inbox
    And Select One Way trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure, after "5" day from today
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
    Then Booking Confirmation email is displayed






  Scenario: Verify that the anonymous user can book a Round-Trip trip
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
    Then 'Thank you for booking with Fly365' message is displayed


  Scenario: Verify that the Booking Confirmation email contains 'Tax Invoice' and 'Booking Confirmation' pdf (Round Trip)
    And Delete all messages in the Inbox
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
    Then Booking Confirmation email contains 'Tax Invoice' and 'Booking Confirmation' pdf


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


  Scenario: Verify that the total fare is the same before and after the booking (Round Trip)
    And Select Round Trip trip
    And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
    And Add airport to the Destination "Dublin International (DUB), Ireland"
    And Select the date of the departure for round trip, after "5" day from today
    And Select the date of the return for round trip, after "15" day from today
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


  @delete_pdf
  Scenario: Verify that the the Tax Invoice pdf contains the correct data (Round Trip)
  And Select Round Trip trip
  And Add airport to the Origin "Cairo International Airport (CAI), Egypt"
  And Add airport to the Destination "Dublin International (DUB), Ireland"
  And Select the date of the departure for round trip, after "5" day from today
  And Select the date of the return for round trip, after "15" day from today
    And Select Passengers: "2" adult, "2" child, "2" infant
    And Select "Economy" Class
    And Press on Search Now
    And Press on 'Stops' Filter
    And Select 'One Stop' trips
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | Michael    | William     | Smith     | 15  | February | 1985 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Peter      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |
      | Mr    | John       | Peter       | Frank     | 15  | January  | 2019 |
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
    And Get the different values of the Flight
    And Get the different values of the Flight for the Round Trip
    And Download the tax invoice pdf
    Then The tax invoice pdf contains the correct data for Round Trip

  @delete_pdf
  Scenario: Verify that the the Booking Confirmation pdf contains the correct data (Round Trip)
    And Select Round Trip trip
    And Add airport to the Origin "Auckland International (AKL), New Zealand"
    And Add airport to the Destination "Canberra (CBR), Australia"
    And Select the date of the departure for round trip, after "5" day from today
    And Select the date of the return for round trip, after "15" day from today
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Press on Search Now
    And Press on 'Stops' Filter
    And Select 'One Stop' trips
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |
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
    And Get the different values of the Flight
    And Get the different values of the Flight for the Round Trip
    And Download the booking confirmation pdf
    Then The booking confirmation pdf contains the correct data for Round Trip

  Scenario: Verify that the Booking Confirmation email is sent successfully (Round Trip)
    And Delete all messages in the Inbox
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
    Then Booking Confirmation email is displayed





  Scenario: Verify that the anonymous user can book a Multi City trip
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
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
    Then 'Thank you for booking with Fly365' message is displayed

  Scenario: Verify that the Booking Confirmation email contains 'Tax Invoice' and 'Booking Confirmation' pdf (Multi City Trip)
    And Delete all messages in the Inbox
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
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
    Then Booking Confirmation email contains 'Tax Invoice' and 'Booking Confirmation' pdf

  Scenario: Verify that the user can retrieve his booking from Find my Booking (Multi City Trip)
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
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

  Scenario: Verify that the total fare is the same before and after the booking (Multi City Trip)
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
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

  @delete_pdf
  Scenario: Verify that the the Tax Invoice pdf contains the correct data (Multi City)
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
    And Select Passengers: "2" adult, "2" child, "2" infant
    And Select "Economy" Class
    And Press on Search Now
    And Press on 'Stops' Filter
    And Select 'One Stop' trips
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | Michael    | William     | Smith     | 15  | February | 1985 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Peter      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |
      | Mr    | John       | Peter       | Frank     | 15  | January  | 2019 |
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
    And Get the different values of the Flight
    And Get the different values of the Flight for the Round Trip
    And Get the different values of the Flight for the Multi City
    And Download the tax invoice pdf
    Then The tax invoice pdf contains the correct data for Multi City

  @delete_pdf
  Scenario: Verify that the the Booking Confirmation pdf contains the correct data (Multi City)
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                    | Destination                               | Date Period |
      | Auckland International (AKL), New Zealand | Canberra (CBR), Australia                 | 10          |
      | Canberra (CBR), Australia                 | Auckland International (AKL), New Zealand | 20          |
      | Auckland International (AKL), New Zealand | Canberra (CBR), Australia                 | 30          |
    And Select Passengers: "1" adult, "1" child, "1" infant
    And Press on Search Now
    And Press on 'Stops' Filter
    And Select 'One Stop' trips
    And Choose a trip
    And Add the following data in the passenger Details
      | Title | First Name | Middle Name | Last Name | Day | Month    | Year |
      | Mr    | John       | William     | Smith     | 15  | February | 1985 |
      | Mr    | Frank      | William     | Smith     | 15  | February | 2012 |
      | Mr    | Paul       | Peter       | Frank     | 15  | January  | 2019 |
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
    And Get the different values of the Flight
    And Get the different values of the Flight for the Round Trip
    And Get the different values of the Flight for the Multi City
    And Download the booking confirmation pdf
    Then The booking confirmation pdf contains the correct data for Multi City

  Scenario: Verify that the Booking Confirmation email is sent successfully (Multi City Trip)
    And Delete all messages in the Inbox
    And Select Multi City trip
    And Choose the number of flights "3"
    And Add the following origin, destinations and date periods
      | Origin                                   | Destination                               | Date Period |
      | Cairo International Airport (CAI), Egypt | Dublin International (DUB), Ireland       | 10          |
      | Dublin International (DUB), Ireland      | Cairo International Airport (CAI), Egypt  | 20          |
      | Cairo International Airport (CAI), Egypt | Auckland International (AKL), New Zealand | 30          |
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
    Then Booking Confirmation email is displayed

#    Then The tax invoice pdf is downloaded
    #    And Add a valid data for the Billing Address
#      | Addres Line 1            | Addres Line 2                | State      | Zip Code |
#      | 8287 Lincoln Rd. Fontana | 64 West Evergreen Lane Tracy | California | 90001    |

#  Scenario: Email
#    And get data from database
