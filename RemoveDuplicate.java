import java.util.Scanner;

public class RemoveDuplicate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String result = removeDuplicates(input);

        System.out.println("String after removing duplicates: " + result);

        scanner.close();
    }

    public static String removeDuplicates(String str) {
        StringBuilder uniqueStr = new StringBuilder();
        boolean[] seen = new boolean[256];  // Array to track seen characters

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                uniqueStr.append(ch);
            }
        }

        return uniqueStr.toString();
    }
}

