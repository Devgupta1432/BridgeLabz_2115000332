import java.util.Scanner;
class large {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n1 = s.nextInt();
       int n2 = s.nextInt();
       int n3 = s.nextInt();
       System.out.println("Is the first number the largest? " + (n1 > n2 && n1 > n3));
       System.out.println("Is the second number the largest? " + (n2 > n1 && n2 > n3));
       System.out.println("Is the third number the largest? " + (n3 > n1 && n3 > n2));
   
   }
}
