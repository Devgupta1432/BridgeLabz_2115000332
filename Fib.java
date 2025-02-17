
public class Fib {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] fibNumbers = {10, 30, 50};

        for (int n : fibNumbers) {
            long start = System.nanoTime();
            fibonacciRecursive(n);
            System.out.println("Recursive Fibonacci for N=" + n + ": " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            fibonacciIterative(n);
            System.out.println("Iterative Fibonacci for N=" + n + ": " + (System.nanoTime() - start) / 1e6 + "ms");
        }
    }
}


