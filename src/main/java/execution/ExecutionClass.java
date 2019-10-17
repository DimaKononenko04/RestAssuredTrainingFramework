package execution;

import com.restapi.endpoints.AccessEndpoints;
import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.RequestManager;
import com.restapi.manager.ResponseManager;
import io.restassured.response.Response;
import utils.PropertiesManager;
import work_with_api.apod_of_the_day.model.ApodOfTheDay;
import work_with_api.apod_of_the_day.resources.Entity;

public class ExecutionClass extends BaseClass {
    public static void main(String[] args) {
        accessBaseUri(AccessEndpoints.BASE_URI);
        Response response = RequestManager.performRequest(ServicesEndpoints.APOD_API_ENDPOINT,PropertiesManager.
                getPropertyValueByName("nasa_api_access","api_key"));
        String apodOfTheDayJsonString = ResponseManager.getResponse(response);
        ApodOfTheDay apodOfTheDayContent = Entity.getContent(apodOfTheDayJsonString,ApodOfTheDay.getApodOfTheDay());
        System.out.println(apodOfTheDayContent.getTitle());
        System.out.println(apodOfTheDayContent.getExplanation());
        System.out.println(apodOfTheDayContent.getUrl());
        System.out.println(apodOfTheDayContent.getHdUrl());
    }

}
