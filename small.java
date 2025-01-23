import java.util.Scanner;
class small {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n1 = s.nextInt();
       int n2 = s.nextInt();
       int n3 = s.nextInt();
       System.out.println("Is the first number the smallest? " + (n1 < n2 && n1 < n3));
   }
}
