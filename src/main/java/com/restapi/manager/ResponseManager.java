package com.restapi.manager;

import io.restassured.response.Response;


public class ResponseManager {


    private ResponseManager(){
    }

    public static String getNasaApodOfTheDayResponse(String api_key){
        Response response = RequestManager.getNasaPictureOfTheDay(api_key);
//        return response.getBody().prettyPrint();
        return response.getBody().asString();
    }

}
