package com.restapi.manager;

import io.restassured.response.Response;


public class ResponseManager {

    private ResponseManager(){
    }

    public static String getResponse(Response response){
        return response.getBody().asString();
    }

}
