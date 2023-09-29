
@Parallel
Feature: Closest to you IKEA

  Scenario:Get nearest store information

    Given Navigate to website
    When Verify you are on the IKEA website
    And Click on the Ikea tab closest to you
    And Random choose an IKEA store
    And Print the store's address and working hours information to an Excel file
    And Return to home page
    Then verify you are back to the home page