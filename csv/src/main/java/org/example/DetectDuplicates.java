import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();
        Set<String> uniqueIds = new HashSet<>();
        List<String[]> duplicates = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            boolean isHeader = true;

            while ((line = reader.readNext()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                if (!uniqueIds.add(line[0])) {
                    duplicates.add(line);
                }
            }

            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records found:");
                for (String[] dup : duplicates) {
                    System.out.println(Arrays.toString(dup));
                }
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
