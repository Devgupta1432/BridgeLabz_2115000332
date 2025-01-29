import java.util.Scanner;

public class compare{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String string1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String string2 = scanner.nextLine();

        int result = compareStringsLexicographically(string1, string2);

        if (result < 0) {
            System.out.println("\"" + string1 + "\" comes before \"" + string2 + "\" in lexicographical order.");
        } else if (result > 0) {
            System.out.println("\"" + string1 + "\" comes after \"" + string2 + "\" in lexicographical order.");
        } else {
            System.out.println("Both strings are equal.");
        }

        scanner.close();
    }

    public static int compareStringsLexicographically(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);

            if (char1 != char2) {
                return char1 - char2;
            }
        }

        return str1.length() - str2.length();
    }
}


