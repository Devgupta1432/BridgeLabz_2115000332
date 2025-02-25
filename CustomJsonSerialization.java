import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) {
        Map<String, Object> jsonMap = new HashMap<>();
        Class<?> objClass = obj.getClass();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                String jsonKey = field.getAnnotation(JsonField.class).name();
                try {
                    jsonMap.put(jsonKey, field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        
        try {
            return new ObjectMapper().writeValueAsString(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}

public class CustomJsonSerialization {
    public static void main(String[] args) {
        User user = new User("JohnDoe", 25);
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}
