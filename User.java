import java.io.*;

public class User {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("User input has been saved to " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
