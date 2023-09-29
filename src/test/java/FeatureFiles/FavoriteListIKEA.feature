
@Parallel
Feature: Favorite List IKEA

  Scenario: Add to product to the favorite list



    Given Navigate to website
    When Click on all furniture
    And  Click on garden furniture
    And Click on the Garden tables
    And Random choose a product
    And Add product to favorites
    And  Go to favorites and add the selected product to the cart
    And Go to cart and delete the product
    And Verify cart is empty
    And Go back to home page
    Then verify you are back to the home page