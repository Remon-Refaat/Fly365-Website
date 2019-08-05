Feature: tickets

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