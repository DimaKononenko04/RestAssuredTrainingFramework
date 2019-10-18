package com.restapi.endpoints;

import io.restassured.RestAssured;

public class AccessEndpoints {

    public static final String BASE_NASA_URI = "https://api.nasa.gov/";
    public static final String BASE_LPR_URI = "https://api.platerecognizer.com/";

    public static void accessBaseUri(String baseUri){
        RestAssured.baseURI = baseUri;
    }

}
