Feature: Use Contact Us Page

  Background: Open Fly365 site
    Given Navigate to Fly365 "stage" site


  Scenario: Verify that "Contact Us" page match with New Zealand site
    Given Press on first 'Contact Us'
    Then 'Contact Us' page is opened matching New Zealand site


  Scenario: Verify that the user can send message through contact us page
    Given Press on first 'Contact Us'
    And Enter Full Name
    And Enter Email
    And Choose Category
    And Write the message
    And Click Send
    Then Success message displayed

  Scenario: Verify that the user received email when send message through contact us page
    Given Press on first 'Contact Us'
    And Enter Full Name
    And Enter Email
    And Choose Category
    And Write the message
    And Click Send
    Then Contact us email is sent successfully