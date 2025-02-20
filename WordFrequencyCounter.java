import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "input.txt";  

        try {
            Map<String, Integer> wordCount = countWordFrequency(filePath);
            System.out.println(wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");

            for (String word : words) {
                if (!word.isEmpty()) {
                    wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        
        reader.close();
        return wordMap;
    }
}
