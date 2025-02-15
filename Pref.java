import java.io.*;

public class Pref {
    public static void main(String[] args) {
        compareStringBuilderAndBuffer();
        compareFileReaderAndInputStreamReader("largefile.txt");
    }

    public static void compareStringBuilderAndBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long durationBuffer = System.nanoTime() - startTimeBuffer;

        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long durationBuilder = System.nanoTime() - startTimeBuilder;

        System.out.println("StringBuffer time: " + durationBuffer / 1_000_000 + " ms");
        System.out.println("StringBuilder time: " + durationBuilder / 1_000_000 + " ms");
    }

    public static void compareFileReaderAndInputStreamReader(String fileName) {
        long wordCountFileReader = countWordsUsingFileReader(fileName);
        long wordCountInputStreamReader = countWordsUsingInputStreamReader(fileName);

        System.out.println("Word count using FileReader: " + wordCountFileReader);
        System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
    }

    public static long countWordsUsingFileReader(String fileName) {
        long wordCount = 0;
        long startTime = System.nanoTime();

        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("FileReader time: " + duration / 1_000_000 + " ms");
        return wordCount;
    }

    public static long countWordsUsingInputStreamReader(String fileName) {
        long wordCount = 0;
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }

        long duration = System.nanoTime() - startTime;
        System.out.println("InputStreamReader time: " + duration / 1_000_000 + " ms");
        return wordCount;
    }
}
