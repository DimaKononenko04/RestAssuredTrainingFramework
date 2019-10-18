package com.tests;

import com.restapi.endpoints.AccessEndpoints;
import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.RequestManager;
import com.restapi.manager.ResponseManager;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utils.PropertiesManager;
import work_with_api.apod_of_the_day.model.ApodOfTheDay;
import work_with_api.apod_of_the_day.resources.Entity;

public class TestNasaApi {
    @Test
    public void test(){
        AccessEndpoints.accessBaseUri(AccessEndpoints.BASE_NASA_URI);
        Response response = RequestManager.performRequest(ServicesEndpoints.APOD_API_ENDPOINT, PropertiesManager.
                getPropertyValueByName("nasa_api_access","api_key"));
        String apodOfTheDayJsonString = ResponseManager.getResponse(response);
        ApodOfTheDay apodOfTheDayContent = Entity.getContent(apodOfTheDayJsonString,ApodOfTheDay.getApodOfTheDay());
        Assert.assertNotNull(apodOfTheDayJsonString);
    }

}
