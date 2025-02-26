import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ConvertCsvToJson {
    public static void main(String[] args) {
        String csvFilePath = "src/main/resources/data.csv";
        String jsonFilePath = "src/main/resources/data.json";

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            List<String[]> records = reader.readAll();
            List<Map<String, String>> jsonList = new ArrayList<>();

            String[] headers = records.get(0);
            for (int i = 1; i < records.size(); i++) {
                Map<String, String> jsonObject = new HashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    jsonObject.put(headers[j], records.get(i)[j]);
                }
                jsonList.add(jsonObject);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new FileWriter(jsonFilePath), jsonList);

            System.out.println("CSV converted to JSON successfully.");

        } catch (IOException e) {
            System.out.println("Error converting CSV to JSON: " + e.getMessage());
        }
    }
}
