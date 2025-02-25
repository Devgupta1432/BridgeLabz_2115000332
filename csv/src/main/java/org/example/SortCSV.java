import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortCSV {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            if (records.size() <= 1) {
                System.out.println("Not enough records to sort!");
                return;
            }

            String[] header = records.get(0);
            List<String[]> data = records.subList(1, records.size());

            data.sort(Comparator.comparingDouble(row -> -Double.parseDouble(row[3])));

            System.out.println(Arrays.toString(header));
            data.stream().limit(5).forEach(row -> System.out.println(Arrays.toString(row)));

        } catch (IOException | CsvException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
