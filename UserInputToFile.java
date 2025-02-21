import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter("userinfo.txt")) {

            System.out.print("Enter name: ");
            String name = br.readLine();
            System.out.print("Enter age: ");
            String age = br.readLine();
            System.out.print("Enter favorite programming language: ");
            String lang = br.readLine();

            fw.write(name + ", " + age + ", " + lang);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
