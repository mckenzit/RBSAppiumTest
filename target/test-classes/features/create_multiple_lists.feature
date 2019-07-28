@sanity
Feature: Create lists

  Background:
    Given I am on the layout page
    And I choose "bottom" layout

  Scenario: Create 2 new lists and delete 1
    Given I am on the shopping list page
    And I add 2 new items
    And I create 1 new list
    And I add 2 new items
    When I delete the list
    Then there should be 1 remaining list

  Scenario: Create a new list and sort it
    Given I am on the shopping list page
    And I add several new items
    When I sort the items
    Then they should be in the order I expected