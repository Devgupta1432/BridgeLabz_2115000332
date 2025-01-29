import java.util.Scanner;

public class substring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();

        System.out.print("Enter the substring to search: ");
        String substring = scanner.nextLine();

        int count = countSubstringOccurrences(mainString, substring);

        System.out.println("The substring occurs " + count + " times in the main string.");

        scanner.close();
    }

    public static int countSubstringOccurrences(String mainString, String substring) {
        int count = 0;
        int index = 0;

        while ((index = mainString.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}


