Feature: Open Top Offers page

  Background: Open Fly365 site
    Given Navigate to "NZ" Fly365 "stage" site

  Scenario: Verify that the user can open top offers
    Given Click on one offer from top offers
    Then  Check the selected offer page open
