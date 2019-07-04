package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;

public class ReadCsv {
    public static List<OnlineCourse> readCsvWithHeader(File csvFile) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<OnlineCourse> onlineCourseIter = csvMapper.readerWithTypedSchemaFor(OnlineCourse.class).with(schema).readValues(csvFile);

        return onlineCourseIter.readAll();
    }

    public static List<Person> readCsvWithoutHeader(File csvFile) throws Exception {
        MappingIterator<Person> personIter = new CsvMapper().readerWithTypedSchemaFor(Person.class).readValues(csvFile);

        return personIter.readAll();
    }
}
