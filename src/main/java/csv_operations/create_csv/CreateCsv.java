package csv_operations.create_csv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import xml_parsing.Employee;
import xml_parsing.ParseXml;


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CreateCsv {

        public static void writeCsv(String filePath){
            List<User> users = new ArrayList<User>();

            User user = new User();
            user.setId(1);
            user.setFirstName("John");
            user.setLastName("Doe");
            users.add(user);

            user = new User();
            user.setId(2);
            user.setFirstName("Enthony");
            user.setLastName("Koll");
            users.add(user);

            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(filePath);
                fileWriter.append("Id, First Name, Last Name\n");
                for(User u: users){
                    fileWriter.append(String.valueOf(u.getId()));
                    fileWriter.append(",");
                    fileWriter.append(u.getFirstName());
                    fileWriter.append(",");
                    fileWriter.append(u.getLastName());
                    fileWriter.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    public static List<String> createCsvFileWithEmployees(){
            ArrayList<Employee> employeeList = ParseXml.getEmployees().getEmployee();
            List<String> dataToPutIntoCsv = new LinkedList<String>();
            for (Employee employee : employeeList) {
                GsonBuilder gsonMapBuilder = new GsonBuilder();
                Gson gsonObject = gsonMapBuilder.create();
                Map<String, String> csvFile = new LinkedHashMap<String, String>();
                csvFile.put("id", employee.getId().toString());
                csvFile.put("first_name", employee.getFirstName());
                csvFile.put("last_name", employee.getLastName());
                csvFile.put("location", employee.getLocation());
                String jsonObject = gsonObject.toJson(csvFile);
                dataToPutIntoCsv.add(jsonObject);
            }
            return dataToPutIntoCsv;
        }

    public static void main(String[] args) {
//        System.out.println(CreateCsv.createCsvFileWithEmployees());
        String filePath = "C:\\Users\\Dmytro_Kononenko1\\IdeaProjects\\RestAssuredTrainingFramework\\src\\main\\java\\csv_operations\\create_csv\\user.csv";

    }

}
