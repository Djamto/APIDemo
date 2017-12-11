package com.demo.api.base;

import com.demo.api.config.ApiConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.*;

/**
 * Created by darjandjamtovski on 11/30/17.
 */
public class Endpoint {

    private RequestSpecification requestSpecification;
    private Response response;
    private ApiConfig apiConfig = new ApiConfig();
    private String endpointUrl;

    public enum RequstMethod{
        GET, POST
    }

    public Endpoint(){
        requestSpecification = given();
    }

    public RequestSpecification setHeader(){
        String token = apiConfig.getProperty(ApiConfig.API_TOKEN);
        String tokenKey = apiConfig.getProperty(ApiConfig.API_TOKEN_KEY);
        Header header = new Header(tokenKey, token);
        requestSpecification.header(header);

        return requestSpecification;
    }

    public RequestSpecification sendRequest(String endpointUrl, RequstMethod requestMethod) throws MalformedURLException{

        String baseAPIUrl = apiConfig.getProperty(ApiConfig.API_BASE_ENDPOINT);
        this.endpointUrl = String.format("%s%s", baseAPIUrl, endpointUrl);
        URL endpointAPIUrl = new URL(this.endpointUrl);

        switch (requestMethod){
            case GET:
                response = requestSpecification.when().get(endpointAPIUrl);
                break;
            case POST:
                response = requestSpecification.when().post(endpointAPIUrl);
                break;

        }

        return requestSpecification;
    }

    public ValidatableResponse readResponse(){
        return response.then();
    }

    public String getEndpointUrl(){
        return endpointUrl;
    }
}
