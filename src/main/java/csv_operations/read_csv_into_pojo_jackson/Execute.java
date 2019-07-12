package csv_operations.read_csv_into_pojo_jackson;

import utils.PropertiesManager;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class Execute {
    public static void main(String[] args) throws Exception {
        File csvWithHeader = new File(PropertiesManager.getAppPropertyValueByName("csvFilePath","online_course"));
        List<OnlineCourse> onlineCourses = ReadCsv.readCsvWithHeader(csvWithHeader,OnlineCourse.getOnlineCourse());
        System.out.println(onlineCourses.get(2).getAuthor());

        File csvWithoutHeader = new File(PropertiesManager.getAppPropertyValueByName("csvFilePath","person"));
        List<Person> personList = ReadCsv.readCsvWithoutHeader(csvWithoutHeader,Person.getPerson());
        System.out.println(personList.get(0).getName());
        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate);
    }

}
