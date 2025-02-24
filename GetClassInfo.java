import java.lang.reflect.*;

class GetClassInfo {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = args[0];
        Class<?> clazz = Class.forName(className);

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Field[] fields = clazz.getDeclaredFields();
        System.out.println("\nFields:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }
    }
}
