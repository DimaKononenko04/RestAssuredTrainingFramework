package check_orders_jsons.lackson;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
}
