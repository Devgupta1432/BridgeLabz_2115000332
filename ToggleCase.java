import java.util.Scanner;

public class ToggleCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String toggledString = toggleCase(input);

        System.out.println("String after toggling case: " + toggledString);

        scanner.close();
    }

    public static String toggleCase(String str) {
        StringBuilder toggledStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                toggledStr.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggledStr.append(Character.toUpperCase(ch));
            } else {
                toggledStr.append(ch);
            }
        }

        return toggledStr.toString();
    }
}



