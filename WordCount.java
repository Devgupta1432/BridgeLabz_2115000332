import java.io.*;

public class WordCount {
    public static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;

        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String fileName = "example.txt";
        String targetWord = "Java";

        int occurrences = countWordOccurrences(fileName, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}
