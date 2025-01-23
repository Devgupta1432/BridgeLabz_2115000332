import java.util.Scanner;
class fact {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       if (n >= 0) {
           int factorial = 1;
           for (int i = 1; i <= n; i++) {
               factorial *= i;
           }
           System.out.println("Factorial: " + factorial);
       } else {
           System.out.println("Invalid input");
       }
   }
}

