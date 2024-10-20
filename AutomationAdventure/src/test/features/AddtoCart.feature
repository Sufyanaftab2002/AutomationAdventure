Feature: Add product to cart

  Background:
    Given User is logged In

  Scenario: Add a product to the cart

    When User clicks on add to cart button
    And product is added to the cart successfully
    And User clicks on Cart
    Then Item should be shown in the cart