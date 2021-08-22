Feature: Searching weathstack api using an apikey

  Scenario Outline: Searching weatherstack api with a limited access api key should give appropriate response
    When I search for <type> weather in <country>
    Then the response code should be <responseStatusCode>
    Then the response body should contain error <errorCode>
    Then the response body should contain error string <error>
    Examples:
      | type       | country | responseStatusCode | errorCode | error                                    |
      | historical | Italy   | 200                | 603       | historical_queries_not_supported_on_plan |
      | invalid    | Italy   | 200                | 103       | invalid_api_function                     |

    Scenario: Searching weatherstack api without access key
      When I search without AccessKey for current weather in Italy
      Then the response code should be 200
      Then the response body should contain error 101
      Then the response body should contain error string missing_access_key

    Scenario: Searching weatherstack api without country query parameter
      When I search without country for current weather
      Then the response code should be 200
      Then the response body should contain error 601
      Then the response body should contain error string missing_query

    Scenario: Searching weatherstack api with invalid access key
      When I search with invalid AccessKey for current weather in Italy
      Then the response code should be 200
      Then the response body should contain error 101
      Then the response body should contain error string invalid_access_key

    Scenario: Searching weatherstack api with invalid access key
      When I search https endpoint for current weather in Italy
      Then the response code should be 200
      Then the response body should contain error 105
      Then the response body should contain error string https_access_restricted

