import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ValidateJsonEmail {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/users.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            for (JsonNode user : rootNode) {
                String email = user.get("email").asText();
                if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    System.out.println("Valid email: " + email);
                } else {
                    System.out.println("Invalid email: " + email);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }
}
