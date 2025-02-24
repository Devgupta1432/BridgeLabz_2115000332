import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "OLD_KEY";

    public static String getApiKey() {
        return API_KEY;
    }
}

class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "NEW_SECURE_KEY");
        
        System.out.println("Updated API Key: " + Configuration.getApiKey());
    }
}
