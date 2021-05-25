Feature: Get batches and product details

  Scenario: Get all batches
    When the uri with endpoint "/batches" is used
    Then all the batches will be displayed
    And the status will then be 200

  Scenario Outline: Get product details by batch id and id
    Given the <batch_id> and <id> is given
    Then the product with the given <batch_id> and <id> will be displayed
    And the status will be 200
    Examples:
      |batch_id| id |
      |1       |11  |
      |2       |21  |
      |2       |22  |
      |3       |31  |

