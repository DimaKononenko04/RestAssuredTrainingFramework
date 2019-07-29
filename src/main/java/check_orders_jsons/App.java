package check_orders_jsons;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import utils.PropertiesManager;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        // how to parse array of json's
        Gson gson = new Gson();
        String ordersCreatedFilePath = PropertiesManager.getAppPropertyValueByName("jsonFile","orders_created_json_set");
        String initialOrders = PropertiesManager.getAppPropertyValueByName("jsonFile","initial_orders");
        JsonReader initialOrdersFile = new JsonReader(new FileReader(initialOrders));
        JsonReader ordersCreatedFile = new JsonReader(new FileReader(ordersCreatedFilePath));

        Order[] orders = gson.fromJson(initialOrdersFile,Order[].class);
        OrderCreated[] ordersCreated = gson.fromJson(ordersCreatedFile,OrderCreated[].class);

        for (OrderCreated tmp: ordersCreated) {
            tmp.getSalesOrderLines().forEach(salesOrderLines -> System.out.println(salesOrderLines.getSellersMaterial()));
        }
        System.out.println();
        for (Order temp: orders) {
            System.out.println(temp.getShipTo());
        }


    }
}
