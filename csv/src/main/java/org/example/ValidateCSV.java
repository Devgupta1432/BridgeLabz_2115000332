import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = Paths.get("src", "main", "resources", "employees.csv").toString();
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();
            if (records.size() <= 1) {
                System.out.println("No data to validate.");
                return;
            }

            String[] header = records.get(0);
            System.out.println("Validating records...");

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                String email = row[2];
                String phone = row[3];

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Invalid Email: " + email + " in row " + (i + 1));
                }
                if (!phonePattern.matcher(phone).matches()) {
                    System.out.println("Invalid Phone Number: " + phone + " in row " + (i + 1));
                }
            }
        } catch (IOException | CsvException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
