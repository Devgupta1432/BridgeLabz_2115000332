import java.util.*;
public class NumberChecker1 {
    public static int countDigits(int n) {
        return String.valueOf(Math.abs(n)).length();
    }
    public static int[] getDigitsArray(int n) {
        String s = String.valueOf(Math.abs(n));
        int[] d = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            d[i] = Character.getNumericValue(s.charAt(i));
        return d;
    }
    public static int sumOfDigits(int n) {
        int s = 0;
        for (int d : getDigitsArray(n))
            s += d;
        return s;
    }
    public static int sumOfSquaresOfDigits(int n) {
        int s = 0;
        for (int d : getDigitsArray(n))
            s += Math.pow(d, 2);
        return s;
    }
    public static boolean isHarshadNumber(int n) {
        return n % sumOfDigits(n) == 0;
    }
    public static int[][] digitFrequency(int n) {
        int[] d = getDigitsArray(n);
        int[][] f = new int[10][2];
        for (int i = 0; i < 10; i++)
            f[i][0] = i;
        for (int i : d)
            f[i][1]++;
        return f;
    }
    public static void main(String[] a) {
        int n = 153;
        System.out.println("Count of digits: " + countDigits(n));
        System.out.print("Digits array: ");
        for (int d : getDigitsArray(n))
            System.out.print(d + " ");
        System.out.println();
        System.out.println("Sum of digits: " + sumOfDigits(n));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(n));
        System.out.println("Is Harshad Number: " + isHarshadNumber(n));
        System.out.println("Digit frequencies:");
        for (int[] f : digitFrequency(n))
            if (f[1] > 0)
                System.out.println("Digit " + f[0] + ": " + f[1]);
    }
}
