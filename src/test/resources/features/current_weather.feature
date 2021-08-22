Feature: Searching current weather in weatherstack

  Scenario Outline: Searching current weather by a valid country should give appropriate response
    When I search for current weather in <country>
    Then the response code should be <responseStatusCode>
    Then the response should be of <country>
    Examples:
      | country                  | responseStatusCode |
      | United States of America | 200                |
      | Italy                    | 200                |
      | France                   | 200                |

  Scenario: Searching current weather by an invalid country should give appropriate error response
    When I search for current weather in xyz
    Then the response code should be 200
    Then the response body should contain error 615



