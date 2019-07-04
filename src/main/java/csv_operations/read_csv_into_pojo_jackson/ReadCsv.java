package csv_operations.read_csv_into_pojo_jackson;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.util.List;

public class ReadCsv {
    public static <T> List<T> readCsvWithHeader(File csvFile,T type) throws Exception {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<T> mappingIterator = csvMapper.readerWithTypedSchemaFor(type.getClass()).with(schema).readValues(csvFile);

        return mappingIterator.readAll();
    }

    public static <T> List<T> readCsvWithoutHeader(File csvFile,T type) throws Exception {
        MappingIterator<T> mappingIterator = new CsvMapper().readerWithTypedSchemaFor(type.getClass()).readValues(csvFile);

        return mappingIterator.readAll();
    }
}
