import java.util.Scanner;
public class sumof {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("The number is not a natural number. Exiting...");
            return;
        }
        int sumUsingRecursion = findSumRecursively(n);
        int sumUsingFormula = findSumUsingFormula(n);
        System.out.println("Sum using recursion: " + sumUsingRecursion);
        System.out.println("Sum using formula: " + sumUsingFormula);
        if (sumUsingRecursion == sumUsingFormula) {
            System.out.println("Both results are correct and match!");
        } else {
            System.out.println("There is a discrepancy in the results.");
        }
    }
    public static int findSumRecursively(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + findSumRecursively(n - 1);
        }
    }
    public static int findSumUsingFormula(int n) {
        return (n * (n + 1)) / 2;
    }
}
