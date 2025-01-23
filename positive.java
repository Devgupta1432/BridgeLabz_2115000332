import java.util.Scanner;
class positive {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       System.out.println(n > 0 ? "Positive" : n < 0 ? "Negative" : "Zero");
   }
}
