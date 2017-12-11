Feature: Competitions

  @Competitions
  Scenario: Validate competition with id 444
    Given The API endpoint "/competitions/444" to retrieve the competitions data
    Then Validate the caption of the competition is "Campeonato Brasileiro da Série A"

  @Competitions
  Scenario: Validate competition links with id 444
    Given The API endpoint "/competitions/444" to retrieve the competitions data
    Then Validate the competition links "self;teams;fixtures;leagueTable"

  @Competitions
  Scenario: Validate competition response schema
    Given The API endpoint "/competitions/444" to retrieve the competitions data
    Then Validate the compeition response using json schema with name "competition-schema"
