import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ReadJsonKeysValues {
    public static void main(String[] args) {
        String jsonFilePath = "student.json";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(jsonFilePath));

            printJson(rootNode, "");

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    public static void printJson(JsonNode node, String prefix) {
        if (node.isObject()) {
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> field = it.next();
                printJson(field.getValue(), prefix + field.getKey() + ".");
            }
        } else if (node.isArray()) {
            int index = 0;
            for (JsonNode item : node) {
                printJson(item, prefix + "[" + index + "].");
                index++;
            }
        } else {
            System.out.println(prefix.substring(0, prefix.length() - 1) + " : " + node.asText());
        }
    }
}
