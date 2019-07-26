package check_orders_jsons.lackson;

import com.google.gson.Gson;

public class App {
    public static void main(String[] args){
        String jsonString = "[ \n" +
                "    {\n" +
                "        \"firstName\" : \"abc\",\n" +
                "        \"lastName\" : \"xyz\"\n" +
                "    }, \n" +
                "    {\n" +
                "        \"firstName\" : \"pqr\",\n" +
                "        \"lastName\" : \"str\"\n" +
                "    } \n" +
                "]";

        // how to parse array of json's
        Gson gson = new Gson();
        Student[] students = gson.fromJson(jsonString,Student[].class);
        System.out.println(students[0].getFirstName());

    }
}
