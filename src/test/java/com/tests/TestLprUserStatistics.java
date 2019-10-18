package com.tests;

import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.RequestManager;
import com.restapi.manager.ResponseManager;
import io.restassured.response.Response;
import org.junit.Test;
import utils.PropertiesManager;

public class TestLprUserStatistics {
    @Test
    public void test(){
        Response statistics = RequestManager.getLprApiUserStatistics(ServicesEndpoints.LPR_STATISTICS, PropertiesManager
                .getPropertyValueByName("plateRecognizer","api_key"));
        String userStatistics = ResponseManager.getResponse(statistics);
    }
}
