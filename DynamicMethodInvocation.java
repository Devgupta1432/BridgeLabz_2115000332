import java.lang.reflect.*;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.next();
        
        System.out.print("Enter two numbers: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        MathOperations obj = new MathOperations();
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(obj, num1, num2);
        
        System.out.println("Result: " + result);
        scanner.close();
    }
}
