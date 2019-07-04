package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"name", "surname", "shoesize", "gender"})
public class Person {
    private static Person person;

    public static Person getPerson(){
        return new Person();
    }

    private String name;
    private String surname;
    private int shoesize;
    private String gender;

}
