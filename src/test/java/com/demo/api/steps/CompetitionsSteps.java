package com.demo.api.steps;

import com.demo.api.base.ApiHelper;
import com.demo.api.base.Endpoint;
import com.demo.api.base.SchemaReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;


/**
 * Created by darjandjamtovski on 12/3/17.
 */
public class CompetitionsSteps {

    private ApiHelper apiHelper = new ApiHelper();
    private SchemaReader schemaReader = new SchemaReader();

    @Given ("^The API endpoint \"(.*)\" to retrieve the competitions data$")
    public void givenTheAPIEndpointToRetrieveTheData(String endpointUrl) throws Throwable{
        apiHelper.getEndpoint().sendRequest(endpointUrl, Endpoint.RequstMethod.GET);
    }

    @Then ("^Validate the caption of the competition is \"(.*)\"$")
    public void thenValidateTheCaptionOfTheCompetitionIs(String competitionCaption) throws Throwable{
        apiHelper.getEndpoint().readResponse().body("caption", equalTo(competitionCaption));

    }

    @Then ("^Validate the competition links \"(.*)\"$")
    public void thenValidateTheCompetitionLinks(String links){
        String[] linksArray = links.split(";");
        String endpointUrl = apiHelper.getEndpoint().getEndpointUrl();

        for(int i = 1; i < linksArray.length; i++){
            String link = String.format("%s/%s", endpointUrl, linksArray[i]);
            String jsonPath = String.format("_links.%s.href", linksArray[i]);
            apiHelper.getEndpoint().readResponse().body(jsonPath, equalTo(link));
        }
    }

    @Then ("^Validate the compeition response using json schema with name \"(.*)\"$")
    public void thenValidateTheCompetitionResponseUsingJsonSchema(String schemaName){
        String competitionSchema = schemaReader.readJsonSchema(schemaName);
        apiHelper.getEndpoint().readResponse().body(matchesJsonSchema(competitionSchema));
    }
}
