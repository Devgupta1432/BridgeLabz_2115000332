import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

class Controller {
    @Inject
    private Service service;

    public void useService() {
        service.serve();
    }
}

class DIContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        injectDependencies(controller);
        controller.useService();
    }
}
