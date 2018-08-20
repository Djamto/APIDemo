package com.demo.api.steps;

import com.demo.api.base.ApiHelper;
import com.demo.api.base.Endpoint;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.Matchers.*;

/**
 * Created by darjandjamtovski on 8/16/18.
 */
public class MatchersSteps {

    private ApiHelper apiHelper = new ApiHelper();

    @Given("^The API endpoint \"(.*)\" to retrieve the teams data$")
    public void givenTheApiEndpointToRetrieveTheTeamsData(String endpointUrl) throws Exception {
        apiHelper.getEndpoint().sendRequest(endpointUrl, Endpoint.RequstMethod.GET);
    }

    @Then("^Validate the team name \"(.*)\" with hasItem matcher$")
    public void thenValidateTheTeamName(String teamName) {
        apiHelper.getEndpoint().readResponse().body("teams.name", hasItem(teamName));
    }

    @Then("^Validate the team name \"(.*)\" with hasItems matcher$")
    public void thenValidateTheTeamNameWithHasItemsMatcher(String teamNames) {
        apiHelper.getEndpoint().readResponse().body("teams.name", hasItems(teamNames.split(";")));
    }

    @Then("^Validate the team name \"(.*)\" with anyOf matcher$")
    public void thenValidateTheTeamNameWithAnyOfMatcher(String teamNames) {
        String[] teamNamesArray = teamNames.split(";");
        apiHelper.getEndpoint().readResponse().body("teams[0].name", anyOf(
                is(teamNamesArray[0]), is(teamNamesArray[1])
        ));
    }

    @Then("^Validate the team name \"(.*)\" with allOf matcher$")
    public void thenValidateTheTeamNameWithAllOfMatcher(String teamName) {
        apiHelper.getEndpoint().readResponse().body("teams[0].name", allOf(
                not(isEmptyOrNullString()), equalTo(teamName)
        ));
    }

    @Then("^Validate that the team has anything$")
    public void thenValidateThatTheTeamHasAnything() {
        apiHelper.getEndpoint().readResponse().body("teams.name", anything());
    }

    @Then("^Validate the team name \"(.*)\" with equalTo matcher$")
    public void thenValidateTheTeamNameWithEqualToMatcher(String teamName) {
        apiHelper.getEndpoint().readResponse().body("teams[0].name", equalTo(teamName));
    }

    @Then("^Validate the team code is null$")
    public void thenValidateTheTeamCodeIsNull() {
        apiHelper.getEndpoint().readResponse().body("teams.code", everyItem(is(nullValue())));
    }

    @Then("^Validate the team name \"(.*)\" and short name \"(.*)\"$")
    public void thenValdiateTheTeamNameAndShortName(String teamName, String teamShortName) {
        apiHelper.getEndpoint().readResponse()
                .body("teams[0].name", equalTo(teamName))
                .body("teams[0].shortName", equalTo(teamShortName));
    }
}
