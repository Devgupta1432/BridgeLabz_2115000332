import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FilterJsonByAge {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/users.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            for (JsonNode user : rootNode) {
                if (user.get("age").asInt() > 25) {
                    System.out.println(user.toPrettyString());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
