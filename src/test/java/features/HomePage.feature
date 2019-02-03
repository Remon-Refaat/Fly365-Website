Feature: Home page

  Background:
    Given Navigate to URl

  @Remon
  Scenario: Verify that the user can book a trip
    And Select One Way trip
    And Add airport to the Origin
    And Add airport to the Destination
    And Select the date of the trip
    And Press on Search Now
    And Choose a trip
    And Add a valid data in the passenger form
    And Click on Next Step
    And Add a valid data for the credit card
    And Add a valid data for the Billing Address
    And Select the Fare Rules and Terms and Conditions
    And Press on Pay button
    Then Confirmation message is displayed

  Scenario: Verify that "About Us" link in the footer open on the correct link
    And Press on 'About us'
    Then 'About Us' page is opened

  Scenario: Verify that "Contact Us" link in the footer open on the correct link
    And Press on 'Contact Us'
    Then 'Contact Us' page is opened

  Scenario: Verify that "Sign in" link in the footer open on the correct link
    And Press on 'Sign in'
    Then 'Sign In' page is opened

  Scenario: Verify that "Sign up" link in the footer open on the correct link
    And Press on 'Sign up'
    Then 'Sign Up' page is opened

  Scenario: Verify that "Support Center" link in the footer open on the correct link
    And Press on 'Support Center'
    Then 'Support Center' page is opened

  Scenario: Verify that "FAQs" link in the footer open on the correct link
    And Press on 'FAQs'
    Then 'FAQs' page is opened

  Scenario: Verify that "Terms and Conditions" link in the footer open on the correct link
    And Press on 'Terms and Conditions'
    Then 'Terms and Conditions' page is opened

  Scenario: Verify that "Privacy policy" link in the footer open on the correct link
    And Press on 'Privacy policy'
    Then 'Privacy Policy' page is opened

  Scenario: Verify that "afta" link in the footer open on the correct link
    And Press on 'afta' and verify that page is opened