Feature: Test
  @dataFile:testdata/test_data.xls
  Scenario: "${test_case} - ${description}"
    Given A valid token with auth url "${auth_url}", client id "${client_id}", client secret "${client_secret}", audience "${audience}" and grand type "${grand_type}"
    When I hit the endpoint "${base_url}${extended_url}"
    Then I should receive status code "${res_status_code}"
    And I should receive drug name "${response_data}"