import java.io.*;

public class Student {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("students.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("students.dat"))) {
            System.out.println(dis.readInt() + " - " + dis.readUTF() + " - " + dis.readDouble());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
