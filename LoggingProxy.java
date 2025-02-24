import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }
}

class LoggingProxy {
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("Executing: " + method.getName());
                    return method.invoke(target, args);
                });
    }

    public static void main(String[] args) {
        Greeting greeting = (Greeting) createProxy(new GreetingImpl());
        greeting.sayHello();
    }
}
