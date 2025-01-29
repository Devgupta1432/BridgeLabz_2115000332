import java.util.Scanner;

public class maximum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three integers:");
        int num1 = getUserInput(scanner, "First number: ");
        int num2 = getUserInput(scanner, "Second number: ");
        int num3 = getUserInput(scanner, "Third number: ");

        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + max);

        scanner.close();
    }

    public static int getUserInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
