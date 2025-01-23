import java.util.Scanner;
class table {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int number = s.nextInt();
       for (int i = 6; i <= 9; i++) {
           System.out.println(number + " * " + i + " = " + (number * i));
       }

   }
}
