package plate_recognition.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public class LicensePlate {

    transient private static LicensePlate licensePlate;

    public static LicensePlate getLicensePlate(){
        if (licensePlate == null){
            licensePlate = new LicensePlate();
        }
        return licensePlate;
    }

    @SerializedName("processing_time")
    private double processingTime;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("results")
    private List<Result> results;
    @SerializedName("filename")
    private String fileName;
    @SerializedName("version")
    private int version;
    @SerializedName("camera_id")
    private String cameraId;
}
