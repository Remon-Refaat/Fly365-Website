@Smoke
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
    And 'afta' page is opened