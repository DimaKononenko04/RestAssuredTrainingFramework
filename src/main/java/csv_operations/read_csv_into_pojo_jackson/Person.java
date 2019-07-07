package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"name", "surname", "shoesize", "gender"})
public class Person {
    private static Person person;

    public static Person getPerson(){
        if (person == null) {
            person = new Person();
        }
        return person;
    }

    private String name;
    private String surname;
    private int shoesize;
    private String gender;

    private Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getShoesize() {
        return shoesize;
    }

    public void setShoesize(int shoesize) {
        this.shoesize = shoesize;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
