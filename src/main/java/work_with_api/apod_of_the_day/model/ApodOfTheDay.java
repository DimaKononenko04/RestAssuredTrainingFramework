package work_with_api.apod_of_the_day.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(force = true)

public class ApodOfTheDay{

    transient private static ApodOfTheDay apodOfTheDay;

    public static ApodOfTheDay getApodOfTheDay(){
        if(apodOfTheDay == null){
            apodOfTheDay = new ApodOfTheDay();
        }
        return apodOfTheDay;
    }

    @SerializedName("hdurl")
    private String hdUrl;
    @SerializedName("media_type")
    private String mediaType;
    @SerializedName("service_version")
    private String serviceVersion;
    private String title;
    private String url;
    private String date;
    private String explanation;

}
