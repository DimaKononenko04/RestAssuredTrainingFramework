package plate_recognition.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box {
    private int xmin;
    private int ymin;
    private int ymax;
    private int xmax;
}
