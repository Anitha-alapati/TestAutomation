@tag
Feature: Test Automation

  Scenario: Test Automation Scenario
    Given I add four different products to my wish list
    When I view my wishlist table
    Then I find total four selected items in my wishlist
    When I search for Lowest price product
    And I am able to add the lowest price to my cart
    Then I am able to verify the item in my cart