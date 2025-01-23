import java.util.Scanner;
class fact1 {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       if (n >= 0) {
           int factorial = 1, i = 1;
           while (i <= n) {
               factorial *= i;
               i++;
           }
           System.out.println("Factorial: " + factorial);
       } else {
           System.out.println("Invalid input");
       }
   }
}
