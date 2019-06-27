package apod_of_the_day.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.EqualsAndHashCode;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(force = true)

public class ApodOfTheDayDTO {

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
