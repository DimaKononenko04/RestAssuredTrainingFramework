package execution;

import com.restapi.endpoints.AccessEndpoints;
import com.restapi.endpoints.ServicesEndpoints;
import com.restapi.manager.RequestManager;
import com.restapi.manager.ResponseManager;
import io.restassured.response.Response;
import plate_recognition.model.LicensePlate;
import utils.PropertiesManager;
import work_with_api.apod_of_the_day.resources.Entity;

import java.io.File;

public class Application extends BaseClass{
    public static void main(String[] args) {
        // get Json with information about car
        accessBaseUri(AccessEndpoints.BASE_LPR_URI);
        File file = new File("C:\\Users\\Dmytro_Kononenko1\\Desktop\\Дипломна_Стаття_2019\\LPR_Project\\reviver_digial_license.png");
        Response response = RequestManager.postLicensePlate(ServicesEndpoints.PLATE_READER,PropertiesManager
                .getPropertyValueByName("plateRecognizer","api_key"),file);
        String licensePlateJson = ResponseManager.getResponse(response);
        LicensePlate licensePlate = Entity.getContent(licensePlateJson,LicensePlate.getLicensePlate());
        System.out.println(licensePlate.getResults().get(0).getPlate());

        // get user statistics
        Response statistics = RequestManager.getLprApiUserStatistics(ServicesEndpoints.LPR_STATISTICS,PropertiesManager
                .getPropertyValueByName("plateRecognizer","api_key"));
        String userStatistics = ResponseManager.getResponse(statistics);
        System.out.println(userStatistics);

    }
}
