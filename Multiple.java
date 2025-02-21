
import java.util.*;

public class Multiple{
    public static void main(String[] args) {
        Integer[] arr = {10, 20, 30, 40};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}





