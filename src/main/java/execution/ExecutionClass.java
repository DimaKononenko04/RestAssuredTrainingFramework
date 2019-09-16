package execution;

import com.restapi.endpoints.AccessEndpoints;
import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.ResponseManager;
import utils.PropertiesManager;
import work_with_api.apod_of_the_day.model.ApodOfTheDay;
import work_with_api.apod_of_the_day.resources.Entity;

public class ExecutionClass extends BaseClass {
    public static void main(String[] args) {
        accessBaseUri(AccessEndpoints.BASE_URI);

        String apodOfTheDayJsonString = ResponseManager.getResponse(ServicesEndpoints.APOD_API_ENDPOINT,PropertiesManager.
                getAppPropertyValueByName("nasa_api_access","api_key"));

        ApodOfTheDay apodOfTheDayContent = Entity.getContent(apodOfTheDayJsonString,ApodOfTheDay.getApodOfTheDay());
        System.out.println(apodOfTheDayContent.getTitle());
        System.out.println(apodOfTheDayContent.getExplanation());
        System.out.println(apodOfTheDayContent.getUrl());
        System.out.println(apodOfTheDayContent.getHdUrl());
    }

}
