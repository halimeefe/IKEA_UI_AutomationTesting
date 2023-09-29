
@Parallel
Feature: Swedish Restaurant IKEA

  Scenario: Price control of the selected product



Given Navigate to website
When Click to view restaurant menu
And Click on the Dessert menu
And Print the price of  Apple Tart
Then verify you are back to the home page