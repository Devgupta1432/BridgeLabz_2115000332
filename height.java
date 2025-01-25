import java.util.Scanner;
public class height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        for (int i = 0; i < 11; i++) sum += sc.nextDouble();
        System.out.println("Mean: " + (sum / 11));
    }
}
