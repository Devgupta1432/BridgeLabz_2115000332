import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(filePath));
             Scanner scanner = new Scanner(System.in)) {
            List<String[]> records = reader.readAll();
            if (records.isEmpty()) {
                System.out.println("CSV file is empty!");
                return;
            }
            System.out.print("Enter Employee Name to Search: ");
            String searchName = scanner.nextLine().trim();

            boolean found = false;
            System.out.println("\nSearching...");

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                String name = row[1].trim();

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + row[2]);
                    System.out.println("Salary: $" + row[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (IOException | CsvException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
