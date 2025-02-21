import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("largefile.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy_largefile.txt"))) {

            byte[] buffer = new byte[4096];
            long start = System.nanoTime();
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Time taken: " + (end - start) / 1e6 + " ms");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
