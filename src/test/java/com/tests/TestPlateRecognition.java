package com.tests;

import com.restapi.endpoints.AccessEndpoints;
import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.RequestManager;
import com.restapi.manager.ResponseManager;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import plate_recognition.model.LprInfo;
import utils.PropertiesManager;
import work_with_api.apod_of_the_day.resources.Entity;

import java.io.File;

public class TestPlateRecognition {
    @Test
    public void test(){
        AccessEndpoints.accessBaseUri(AccessEndpoints.BASE_LPR_URI);
        File file = new File("C:\\Users\\Dmytro_Kononenko1\\Desktop\\Дипломна_Стаття_2019\\LPR_Project\\reviver_digial_license.png");
        Response response = RequestManager.postLicensePlate(ServicesEndpoints.PLATE_READER, PropertiesManager
                .getPropertyValueByName("plateRecognizer","api_key"),file);
        String licensePlateJson = ResponseManager.getResponse(response);
        LprInfo lprInfo = Entity.getContent(licensePlateJson, LprInfo.getLPRInfo());
        Assert.assertEquals("3nza760",lprInfo.getResults().get(0).getPlate());
    }
}
