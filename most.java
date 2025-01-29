import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class most {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char mostFrequentChar = findMostFrequentCharacter(input);

        System.out.println("The most frequent character is: " + mostFrequentChar);

        scanner.close();
    }

    public static char findMostFrequentCharacter(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;
        char mostFrequentChar = str.charAt(0);

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            if (frequencyMap.get(ch) > maxFrequency) {
                maxFrequency = frequencyMap.get(ch);
                mostFrequentChar = ch;
            }
        }

        return mostFrequentChar;
    }
}


