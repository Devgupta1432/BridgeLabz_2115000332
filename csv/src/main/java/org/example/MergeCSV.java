import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = Paths.get("src", "main", "resources", "students1.csv").toString();
        String file2 = Paths.get("src", "main", "resources", "students2.csv").toString();
        String outputFile = Paths.get("src", "main", "resources", "merged_students.csv").toString();

        Map<String, String[]> studentData = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            List<String[]> records1 = reader1.readAll();
            for (int i = 1; i < records1.size(); i++) {
                studentData.put(records1.get(i)[0], records1.get(i));
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(file2))) {
            List<String[]> records2 = reader2.readAll();
            for (int i = 1; i < records2.size(); i++) {
                String id = records2.get(i)[0];
                if (studentData.containsKey(id)) {
                    String[] mergedRow = {
                            id,
                            studentData.get(id)[1],
                            studentData.get(id)[2],
                            records2.get(i)[1],
                            records2.get(i)[2]
                    };
                    studentData.put(id, mergedRow);
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            writer.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for (String[] row : studentData.values()) {
                writer.writeNext(row);
            }
            System.out.println("Merged file created successfully: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing merged file: " + e.getMessage());
        }
    }
}
