import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("uppercase.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("lowercase.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
