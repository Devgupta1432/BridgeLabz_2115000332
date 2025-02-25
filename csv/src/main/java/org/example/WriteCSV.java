import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "src/main/resources/employees.csv";
        String[][] employees = {
                {"ID", "Name", "Department", "Salary"},
                {"101", "Alice Johnson", "HR", "55000"},
                {"102", "Bob Smith", "IT", "75000"},
                {"103", "Charlie Davis", "Finance", "68000"},
                {"104", "David Brown", "Marketing", "62000"},
                {"105", "Emma Wilson", "Sales", "60000"}
        };
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            for (String[] emp : employees) {
                writer.writeNext(emp);
            }
            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
