import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File("data.json"));
            if (rootNode.has("name") && rootNode.has("email")) {
                System.out.println("Valid JSON structure.");
            } else {
                System.out.println("Invalid JSON structure.");
            }
        } catch (IOException e) {
            System.out.println("Error reading JSON file.");
        }
    }
}
