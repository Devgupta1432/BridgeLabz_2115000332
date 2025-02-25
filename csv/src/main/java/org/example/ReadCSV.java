import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadCSV {
    public static void main(String[] args) {
        String csvFile = "src/main/resources/students.csv";
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> records = reader.readAll();
            System.out.println("ID\tName\tAge\tMarks");
            System.out.println("--------------------------------");
            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
