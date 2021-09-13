Feature: Test
  @dataFile:testdata/testdata.xls
  Scenario: Just Testing
    When I hit the test method
    Then I should receive "${name}"