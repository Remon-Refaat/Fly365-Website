
Feature: Apply discount on flight trips

  Scenario: Verify that the super admin can access discount campaign
    When Open hub login page
    And  login into hub with super admin
    And  Open Discount
    Then Discount page open

  Scenario: Verify that the super admin can apply discount campaign
    When Open hub login page
    And  login into hub with super admin
    And  Open Discount
    And  Click on Create Campaign
    And  Fill required data for discount rule
    And  Click on Submit
    Then Check Discount rule created successfully

  Scenario: Verify that the super admin can update discount campaign
    When Open hub login page
    And  login into hub with super admin
    And  Open Discount
    And  Open certain store
    And  Click on Update Campaign
    And  Update Name of discount rule
    And  Click on Submit
    Then Check Discount rule updated successfully

    @Eyad
  Scenario: Verify that the enable discount rule applied on search result
    And  Delete new discount from database
    When Apply discount rule from API
    And  Make Search from API
    Then Check Discount rule applied
    And  Delete new discount from database

  Scenario: Verify that the disable discount rule doesn't applied on search result
    When Open hub login page
    And  login into hub with super admin
    And  Open Discount
    And  Open certain store
    And  Click on Update Campaign
    And  Disable the discount rule
    And  Click on Submit
    Then Check Discount rule updated successfully

  @Eyad
  Scenario: Verify that the super admin can disable all discount rules
    When Open hub login page
    And  login into hub with super admin
    And  Open Discount
    And  Open Discount Settings
    And  Disable the discount rule
    And  Click on Submit
    And  Make Search from API
    Then Check Discount rule disabled