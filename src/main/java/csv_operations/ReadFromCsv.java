package csv_operations;

import com.restapi.manager.PropertiesManager;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

public class ReadFromCsv {
    public static void main(String[] args) throws IOException {
        File csvFile = new File(PropertiesManager.getAppPropertyValueByName("csvFilePath","csv_file_path"));
        InputStreamReader input = new InputStreamReader(new FileInputStream(csvFile));
        CSVParser csvParser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(input);
        for (CSVRecord record : csvParser) {
            System.out.println(record.get("Item"));
            System.out.println(record.get("Quantity"));
            System.out.println(record.get("Price"));
            System.out.println(record.get("Description"));
        }
    }
}