import java.util.Scanner;

public class remove {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.print("Enter the character to remove: ");
        char charToRemove = scanner.next().charAt(0);

        String modifiedString = removeCharacter(input, charToRemove);

        System.out.println("Modified String: " + modifiedString);

        scanner.close();
    }

    public static String removeCharacter(String str, char ch) {
        return str.replaceAll(String.valueOf(ch), "");
    }
}

