package com.restapi.manager;

import com.restapi.endpoints.ServicesEndpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestManager {

    public static Response getNasaPictureOfTheDay(String api_key){
        return given()
                .pathParam("api_key",api_key)
                .contentType(ContentType.JSON)
                .when()
                .get(ServicesEndpoints.APOD_API_ENDPOINT)
                .thenReturn();
    }

}
