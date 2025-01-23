import java.util.Scanner;
class divisible {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int number = s.nextInt();
       System.out.println("Is the number " + number + " divisible by 5? " + (number % 5 == 0));
   }
}
