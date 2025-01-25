import java.util.Scanner;
public class dynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int maxDigit = 10, index = 0;
        int[] digits = new int[maxDigit];
        while (num != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(digits, 0, temp, 0, digits.length);
                digits = temp;
            }
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
