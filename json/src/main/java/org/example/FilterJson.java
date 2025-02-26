import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class FilterJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(new File("people.json"));
            for (JsonNode person : rootNode) {
                if (person.get("age").asInt() > 25) {
                    System.out.println(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
