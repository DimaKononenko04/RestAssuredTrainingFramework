package plate_recognition.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private Box box;
    private String plate;
    private double score;
    private double dscore;
    private Vehicle vehicle;
}
