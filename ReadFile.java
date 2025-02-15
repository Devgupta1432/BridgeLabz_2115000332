
import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Change this to the path of your file

        try (FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr)) {
             
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}


