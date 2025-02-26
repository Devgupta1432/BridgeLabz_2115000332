import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;

public class CreateStudentJson {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode student = objectMapper.createObjectNode();

        student.put("name", "John Doe");
        student.put("age", 20);

        ArrayNode subjects = objectMapper.createArrayNode();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("English");
        student.set("subjects", subjects);

        try {
            objectMapper.writeValue(new File("src/main/resources/student.json"), student);
            System.out.println("JSON file created: student.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
