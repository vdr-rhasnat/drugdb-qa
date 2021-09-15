Feature: Test
  @dataFile:drug_db_api_test_data/test_cases.xls
  Scenario: "${test_case} - ${description}"
    Given A valid token with auth url "${auth_url}", client id "${client_id}", client secret "${client_secret}", audience "${audience}" and grand type "${grand_type}"
    When I hit the endpoint "${base_url}${extended_url}"
    Then I should receive status code "${res_status_code}"
    And I should receive drug name "${response_data}"
    And I should receive color "${color}"
    And I should receive package size "${package_size}"