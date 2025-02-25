import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = Paths.get("src", "main", "resources", "employees.csv").toString();
        String outputFile = Paths.get("src", "main", "resources", "updated_employees.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }

            writer.writeNext(records.get(0));

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                if (row[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(row[3]);
                    row[3] = String.valueOf(salary * 1.10);
                }
                writer.writeNext(row);
            }

            System.out.println("Updated salaries saved to updated_employees.csv");

        } catch (IOException | CsvException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
