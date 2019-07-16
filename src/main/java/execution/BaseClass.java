package execution;

import io.restassured.RestAssured;

public class BaseClass {

    public static void accessBaseUri(String baseUri){
        RestAssured.baseURI = baseUri;
    }

}
