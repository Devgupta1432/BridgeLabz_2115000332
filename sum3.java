import java.util.Scanner;
class sum3 {
   public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       double total = 0.0, number;
       while ((number = input.nextDouble()) != 0) {
           total += number;
       }
       System.out.println("Total sum: " + total);
   }
}
