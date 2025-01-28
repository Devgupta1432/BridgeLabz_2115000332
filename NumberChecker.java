import java.util.ArrayList;
import java.util.List;

public class NumberChecker {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigitsArray(int number) {
        String numberStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            digits[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        return digits;
    }

    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        int power = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    public static List<Integer> findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit < largest) {
                secondLargest = digit;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(largest);
        result.add(secondLargest);
        return result;
    }

    public static List<Integer> findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit > smallest) {
                secondSmallest = digit;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(smallest);
        result.add(secondSmallest);
        return result;
    }

    public static void main(String[] args) {
        int number = 153;

        System.out.println("Count of digits: " + countDigits(number));

        int[] digits = getDigitsArray(number);
        System.out.print("Digits array: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Is Duck Number: " + isDuckNumber(number));

        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number));

        List<Integer> largestNumbers = findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: " + largestNumbers.get(0));
        System.out.println("Second largest digit: " + largestNumbers.get(1));

        List<Integer> smallestNumbers = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: " + smallestNumbers.get(0));
        System.out.println("Second smallest digit: " + smallestNumbers.get(1));
    }
}
