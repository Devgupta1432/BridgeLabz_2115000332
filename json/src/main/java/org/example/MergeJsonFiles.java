import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        String file1 = "src/main/resources/file1.json";
        String file2 = "src/main/resources/file2.json";
        String outputFile = "src/main/resources/merged.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode json1 = objectMapper.readTree(new File(file1));
            JsonNode json2 = objectMapper.readTree(new File(file2));

            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) json1);
            mergedJson.setAll((ObjectNode) json2);

            objectMapper.writeValue(new File(outputFile), mergedJson);
            System.out.println("Merged JSON saved to: " + outputFile);
        } catch (IOException e) {
            System.out.println("Error merging JSON files: " + e.getMessage());
        }
    }
}
