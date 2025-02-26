import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class ConvertJsonToXml {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/resources/data.json";
        String xmlFilePath = "src/main/resources/data.xml";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));

            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(xmlFilePath), jsonNode);

            System.out.println("JSON successfully converted to XML.");

        } catch (IOException e) {
            System.out.println("Error converting JSON to XML: " + e.getMessage());
        }
    }
}
