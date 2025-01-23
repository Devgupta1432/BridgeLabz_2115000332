import java.util.Scanner;
class person {
   public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int age = s.nextInt();
       System.out.println("The person's age is " + age + " and " + (age >= 18 ? "can vote." : "cannot vote."));

   }
}
