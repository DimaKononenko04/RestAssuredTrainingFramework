package com.restapi.manager;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RequestManager {

    public static Response performRequest(String endpoint,String apiKey){
        return given()
                .pathParam("api_key",apiKey)
                .contentType(ContentType.JSON)
                .when()
                .get(endpoint)
                .thenReturn();
    }

    public static Response postLicensePlate(String endpoint, String apiKey, File file){
        return given()
                .multiPart("upload",file)
                .header("Authorization","Token" + apiKey)
                .when()
                .post("posturi")
                .thenReturn();
    }

}
