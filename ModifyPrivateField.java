import java.lang.reflect.*;

class Person {
    private int age;
}

class ModifyPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 25);
        System.out.println("Modified Age: " + field.get(person));
    }
}
