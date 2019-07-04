package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.restapi.manager.PropertiesManager;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Execute {
    public static void main(String[] args) throws Exception {
        File csvWithHeader = new File(PropertiesManager.getAppPropertyValueByName("csvFilePath","online_course"));
        List<OnlineCourse> onlineCourses = ReadCsv.readCsvWithHeader(csvWithHeader);
        System.out.println(onlineCourses.size());
        System.out.println(onlineCourses.get(0).getAuthor());

        File csvWithoutHeader = new File(PropertiesManager.getAppPropertyValueByName("csvFilePath","person"));
        List<Person> people = ReadCsv.readCsvWithoutHeader(csvWithoutHeader);
        System.out.println(people.size());
    }

}
