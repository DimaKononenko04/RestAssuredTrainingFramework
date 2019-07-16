package work_with_api.apod_of_the_day.resources;

import com.google.gson.Gson;
import utils.PropertiesManager;
import com.restapi.manager.ResponseManager;
import work_with_api.apod_of_the_day.model.ApodOfTheDayDTO;

public class ApodOfTheDay {
    private static Gson gson;
    private static String jsonString = ResponseManager.getResponse(PropertiesManager.
            getAppPropertyValueByName("access","api_key"));

    public static ApodOfTheDayDTO getNasaApodOfTheDayContent(){
        gson = new Gson();
        return gson.fromJson(jsonString, ApodOfTheDayDTO.class);
    }

}
