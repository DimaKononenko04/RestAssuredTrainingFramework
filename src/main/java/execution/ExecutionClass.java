package execution;

import static work_with_api.apod_of_the_day.resources.ApodOfTheDay.getNasaApodOfTheDayContent;


public class ExecutionClass extends BaseClass {
    public static void main(String[] args) {
        preparation();
        System.out.println(getNasaApodOfTheDayContent().getTitle());
        System.out.println(getNasaApodOfTheDayContent().getExplanation());
    }

}
