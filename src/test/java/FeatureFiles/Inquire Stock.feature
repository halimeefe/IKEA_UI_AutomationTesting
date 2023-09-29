
@Parallel
Feature:Inquire Stock

  Scenario:Product stock control



    Given Navigate to website
    When Click on Products
    And Click on Decoration
    And Click on the Vases
    And Random select a vase and copy the product's code number
    And Click onStock Query
    And Type the product code select a store
    And Verify stock information
    Then verify you are back to the home page