package execution;

import work_with_api.apod_of_the_day.model.ApodOfTheDay;
import work_with_api.apod_of_the_day.resources.Entity;

public class ExecutionClass extends BaseClass {
    public static void main(String[] args) {
        preparation();
        ApodOfTheDay apodOfTheDayContent = Entity.getContent(ApodOfTheDay.getApodOfTheDay());
        System.out.println(apodOfTheDayContent.getTitle());
        System.out.println(apodOfTheDayContent.getExplanation());
    }

}
