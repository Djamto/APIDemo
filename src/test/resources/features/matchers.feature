Feature: Matchers

  @Matchers
  Scenario: Scenario with hasItem matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team name "Avaí SC" with hasItem matcher

  @Matchers
  Scenario: Scenario with hasItems matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team name "Avaí SC;CR Flamengo;Corinthians" with hasItems matcher

  @Matchers
  Scenario: Scenario with anyOf matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team name "Avaí SC;CR Flamengo" with anyOf matcher

  @Matchers
  Scenario: Scenario with allOf matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team name "CR Flamengo" with allOf matcher

  @Matchers
  Scenario: Scenario with anything matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate that the team has anything

  @Matchers
  Scenario: Scenario with equalTo matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team name "CR Flamengo" with equalTo matcher

  @Matchers
  Scenario: Scenario with nullValue matcher
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team code is null

  @Matchers
  Scenario: Scenario with validating multiple attributes in json
    Given The API endpoint "/competitions/444/teams" to retrieve the teams data
    Then Validate the team name "CR Flamengo" and short name "Flamengo"