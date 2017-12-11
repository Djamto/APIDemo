package com.demo.api.base;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Created by darjandjamtovski on 12/3/17.
 */
public class ApiHelper {

    private static Endpoint endpoint;

    @Before
    public void initializeApi(){
        endpoint = new Endpoint();
        endpoint.setHeader();
    }

    @After
    public void finalizeApi(){
        endpoint = null;
    }

    public Endpoint getEndpoint(){
        if(endpoint != null){
            return endpoint;
        }else{
            endpoint = new Endpoint();
            endpoint.setHeader();
        }

        return endpoint;
    }
}
