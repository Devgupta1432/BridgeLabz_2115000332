import java.util.Scanner;
public class largest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int[] digits = new int[10];
        int index = 0;
        while (num != 0 && index < digits.length) {
            digits[index++] = num % 10;
            num /= 10;
        }
        int largest = 0, secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest) {
                secondLargest = digits[i];
            }
        }
        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
    }
}
