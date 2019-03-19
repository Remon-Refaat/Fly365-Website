@New_Tab
Feature: Home page

  Background:
    Given Navigate to Fly365 "stage" site

  Scenario: Verify that "About Us" link in the footer open on the correct link
    And Press on 'About us'
    Then 'About Us' page is opened

  Scenario: Verify that first "Contact Us" link in the footer open on the correct link
    And Press on first 'Contact Us'
    Then 'Contact Us' page is opened

  Scenario: Verify that second "Contact Us" link in the footer open on the correct link
    And Press on second 'Contact Us'
    Then 'Contact Us' page is opened

  Scenario: Verify that "Sign in" link in the footer open on the correct link
    And Press on 'Sign in'
    Then 'Sign In' page will be opened

  Scenario: Verify that "Sign up" link in the footer open on the correct link
    And Press on 'Sign up'
    Then 'Sign Up' page will be opened

  Scenario: Verify that first "Support Center" link in the footer open on the correct link
    And Press on first 'Support Centre'
    Then 'Support Centre' page is opened

  Scenario: Verify that second "Support Center" link in the footer open on the correct link
    And Press on second 'Support Centre'
    Then 'Support Centre' page is opened

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
    And Press on 'afta'
    Then 'afta' page is opened

  Scenario: Verify that the Logo link in the footer open on the correct link
    And Press on Logo in footer
    Then Home page is opened

  Scenario: Verify that the Logo link in the header open on the correct link
    And Press on Logo in header
    Then Home page is opened

  Scenario: Verify that the Flights link in the header open on the correct link
    And Press on flights in header
    Then Home page is opened

  Scenario: Verify that the Offers link in the header open on the correct link
    And Press on offers in header
    Then Offers page is opened

  Scenario: Verify that the Sign In button in the header open on the correct link
    And Press on Sign In button
    Then 'Sign In' page will be opened