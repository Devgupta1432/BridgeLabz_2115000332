import java.util.Scanner;
public class reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int count = 0;
        int[] digits = new int[10];
        while (num != 0) {
            digits[count++] = num % 10;
            num /= 10;
        }
        System.out.print("Reversed Number: ");
        for (int i = count - 1; i >= 0; i--) System.out.print(digits[i]);
    }
}
