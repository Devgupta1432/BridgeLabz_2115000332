import java.util.Scanner;
public class bmi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[][] data = new double[n][3];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight: ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height: ");
            data[i][1] = sc.nextDouble();
            data[i][2] = data[i][0] / (data[i][1] * data[i][1]);
            status[i] = data[i][2] < 18.5 ? "Underweight" : data[i][2] < 24.9 ? "Normal" : data[i][2] < 29.9 ? "Overweight" : "Obese";
        }
        for (int i = 0; i < n; i++) System.out.println("Height: " + data[i][1] + ", Weight: " + data[i][0] + ", BMI: " + data[i][2] + ", Status: " + status[i]);
    }
}
