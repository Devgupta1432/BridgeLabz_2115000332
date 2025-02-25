import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class FilterCSVRecords {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "students.csv").toString();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            System.out.println("Students who scored more than 80 marks:");
            System.out.println("ID\tName\tAge\tMarks");
            System.out.println("--------------------------------");

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                int marks = Integer.parseInt(row[3]);

                if (marks > 80) {
                    System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV file.");
        }
    }
}
