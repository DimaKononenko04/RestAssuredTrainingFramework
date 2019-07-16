package com.restapi.manager;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestManager {

    public static Response performRequest(String endpoint,String api_key){
        return given()
                .pathParam("api_key",api_key)
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .thenReturn();
    }

}
