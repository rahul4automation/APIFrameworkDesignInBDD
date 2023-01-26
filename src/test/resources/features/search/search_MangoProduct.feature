@feature:search @feature:product
Feature: Search product

  @positive
  Scenario Outline: Verify mango product while GET call
    When I hit the GET search API endpoint <product>
    Then I verify the search results of product should be displayed
    And I verify Success status Code should be displayed in search result
    And I verify the product <product> should be in Search results
    Examples:
      | product |
      | mango   |

  @negative
  Scenario: Search test with unavailable product tea
    When I hit the GET search API endpoint Car
    Then I verify 404 status Code for not available  displayed in search result


