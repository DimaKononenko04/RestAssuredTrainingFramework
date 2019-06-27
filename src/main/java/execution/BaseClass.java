package execution;

import com.restapi.endpoints.AccessEndpoints;
import io.restassured.RestAssured;

public class BaseClass {

    public static void preparation(){
        RestAssured.baseURI = AccessEndpoints.BASE_URI;
    }
}
