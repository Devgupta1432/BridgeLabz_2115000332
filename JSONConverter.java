import java.lang.reflect.*;
import java.util.*;

class User {
    private String username = "Alice";
    private int id = 1001;
}

class JSONConverter {
    public static String toJson(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        Map<String, Object> jsonMap = new HashMap<>();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            jsonMap.put(field.getName(), field.get(obj));
        }
        return jsonMap.toString().replace("=", ": ");
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        System.out.println(toJson(user));
    }
}
