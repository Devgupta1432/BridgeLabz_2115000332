import java.util.Scanner;
class spring {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int month = s.nextInt();
       int day = s.nextInt();
       System.out.println((month == 3 && day >= 20) || (month > 3 && month < 6) || (month == 6 && day <= 20) ? "It's a Spring Season" : "Not a Spring Season");

   }
}
