package com.restapi.manager;

import io.restassured.response.Response;


public class ResponseManager {

    private ResponseManager(){
    }

    public static String getResponse(String endpoint,String api_key){
        Response response = RequestManager.performRequest(endpoint,api_key);
        return response.getBody().asString();
    }

}
