import java.util.Scanner;
class bonus {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       double salary = s.nextDouble();
       int years = s.nextInt();
       if (years > 5) {
           double bonus = salary * 0.05;
           System.out.println("Bonus: " + bonus);
       } else {
           System.out.println("No bonus");
       }

   }
}
