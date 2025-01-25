import java.util.Scanner;
public class 2d {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++) 
                array[index++] = sc.nextInt();
        for (int i : array) System.out.print(i + " ");
    }
}
