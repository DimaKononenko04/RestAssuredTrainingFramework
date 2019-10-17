package execution;

import com.restapi.endpoints.AccessEndpoints;
import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.RequestManager;
import com.restapi.manager.ResponseManager;
import io.restassured.response.Response;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import utils.PropertiesManager;

import java.io.File;

public class Execution2 extends BaseClass{
    public static void main(String[] args) {

//        String file = "C:\\Users\\Dmytro_Kononenko1\\Desktop\\Дипломна_Стаття_2019\\LPR_Project\\reviver_digial_license.png";
//        String file = "C:\\Users\\Dmytro_Kononenko1\\Desktop\\Дипломна_Стаття_2019\\LPR_Project\\demo.jpg";
//        String file = "C:\\Users\\Dmytro_Kononenko1\\Desktop\\Дипломна_Стаття_2019\\LPR_Project\\demo2.jpg";
        String file = "C:\\Users\\1\\Desktop\\2019University\\Стаття_та_Практика\\LPR_Project\\AP9701CX.png";
        String token = PropertiesManager.getPropertyValueByName("plateRecognizer","api_key");


        try{
            HttpResponse<String> response = Unirest.post("https://api.platerecognizer.com/v1/plate-reader/")
                    .header("Authorization", "Token "+token)
                    .field("upload", new File(file))
                    .asString();
            System.out.println("Recognize:");
            System.out.println(response.getBody());
        }
        catch(Exception e){
            System.out.println(e);
        }
//
//        try{
//            HttpResponse<String> response = Unirest.get("https://api.platerecognizer.com/v1/statistics/")
//                    .header("Authorization", "Token "+token)
//                    .asString();
//            System.out.println("Usage:");
//            System.out.println(response.getBody());
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }

//        accessBaseUri(AccessEndpoints.BASE_LPR_URI);
//        File file = new File("C:\\Users\\1\\Desktop\\2019University\\Стаття_та_Практика\\LPR_Project\\AP9701CX.png");
//        Response response = RequestManager.postLicensePlate(ServicesEndpoints.PLATE_READER,PropertiesManager
//                .getPropertyValueByName("plateRecognizer","api_key"),file);
//        String licensePlateJson = ResponseManager.getResponse(response);
//        System.out.println(licensePlateJson);

    }
}
