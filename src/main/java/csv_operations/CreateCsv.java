package csv_operations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import xml_parsing.Employee;
import xml_parsing.ParseXml;

import java.util.*;

public class CreateCsv {

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
        System.out.println(CreateCsv.createCsvFileWithEmployees());
    }

}
