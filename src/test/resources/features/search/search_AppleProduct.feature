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

  @negative
  Scenario: Search test with unavailable product tea
    When I hit the GET search API endpoint Car
    Then I verify 404 status Code for not available  displayed in search result

  @negative
  Scenario: Verify GET call without adding any product
    When I hit the get search test endpoint
    Then I verify unauthorized error should be displayed in search result


