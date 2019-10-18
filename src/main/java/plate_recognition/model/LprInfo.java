package plate_recognition.model;

import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor(force = true)
public class LprInfo {

    transient private static LprInfo LPRInfo;

    public static LprInfo getLPRInfo(){
        if (LPRInfo == null){
            LPRInfo = new LprInfo();
        }
        return LPRInfo;
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
