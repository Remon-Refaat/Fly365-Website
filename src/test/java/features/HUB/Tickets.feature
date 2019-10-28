Feature: tickets
  @reply
  Scenario: Verify that super admin can create ticket successfully
    Given Open hub login page
    And login into hub with super admin
    And open Back office
    And open tickets
    And press on create ticket
    And fill message data
    And press send
    Then ticket created



  Scenario: Verify that customer can send direct mail to open a ticket
    Given send direct mail to support mail
    And Open hub login page
    And login into hub with super admin
    And open Back office
    And open tickets
    And press on create ticket
    And fill message data
    And press send
    Then ticket created


  Scenario: Verify that user reply on a booking appears as an open ticket
    And Book a trip from API for "stage" and get "Airline Reference"
    Then Booking Confirmation email is displayed


  @reply
  Scenario: Verify that rule can be created through api
    And Create a Rule from API for "stage"




