package work_with_api.apod_of_the_day.resources;

import com.google.gson.Gson;
import utils.PropertiesManager;
import com.restapi.manager.ResponseManager;
import work_with_api.apod_of_the_day.model.ApodOfTheDay;

import java.lang.reflect.Type;

public class Entity {
    private static Gson gson;
    private static String jsonString = ResponseManager.getResponse(PropertiesManager.
            getAppPropertyValueByName("access","api_key"));

    public static <T> T getContent(T type){
        gson = new Gson();
        return gson.fromJson(jsonString, (Type) type.getClass());
    }

}
