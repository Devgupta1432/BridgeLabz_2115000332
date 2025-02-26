import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonObjects {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode json1 = objectMapper.readTree(new File("data1.json"));
            JsonNode json2 = objectMapper.readTree(new File("data2.json"));

            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            objectMapper.writeValue(new File("merged.json"), mergedJson);
            System.out.println("Merged JSON file created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
