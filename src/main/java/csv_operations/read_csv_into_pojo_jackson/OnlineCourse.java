package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OnlineCourse {
    private static OnlineCourse onlineCourse;

    public static OnlineCourse getOnlineCourse(){
        if(onlineCourse == null){
            onlineCourse = new OnlineCourse();
        }
        return onlineCourse;
    }

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("Price")
    private int price;
}
