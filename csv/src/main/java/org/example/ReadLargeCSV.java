import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "large_file.csv").toString();
        int batchSize = 100;
        int recordCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                recordCount++;

                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
