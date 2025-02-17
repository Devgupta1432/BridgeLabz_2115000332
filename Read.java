
import java.io.*;

public class Read {

    public static void readWithFileReader(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        while (fr.read() != -1);
        fr.close();
    }

    public static void readWithInputStreamReader(String fileName) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName));
        while (isr.read() != -1);
        isr.close();
    }

    public static void main(String[] args) throws IOException {
        String fileName = "D:\dev gupta\Downloads\DBMS ASSIGNMENT 5.txt"; 

        long start = System.nanoTime();
        readWithFileReader(fileName);
        System.out.println("FileReader Time: " + (System.nanoTime() - start) / 1e6 + "ms");

        start = System.nanoTime();
        readWithInputStreamReader(fileName);
        System.out.println("InputStreamReader Time: " + (System.nanoTime() - start) / 1e6 + "ms");
    }
}



