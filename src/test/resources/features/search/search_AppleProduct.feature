@feature:search @feature:product
Feature: Search product

  @positive
  Scenario Outline: Verify Apple product while GET call
    When I hit the GET search API endpoint <product>
    Then I verify the search results of product should be displayed
    And I verify Success status Code should be displayed in search result
    And I verify the product <product> should be in Search results
    Examples:
      | product |
      | apple   |


