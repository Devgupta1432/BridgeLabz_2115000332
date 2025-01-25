import java.util.Scanner;
public class bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();
        double[] weight = new double[n], height = new double[n], bmi = new double[n];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight: ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter height: ");
            height[i] = sc.nextDouble();
            bmi[i] = weight[i] / (height[i] * height[i]);
            status[i] = bmi[i] < 18.5 ? "Underweight" : bmi[i] < 24.9 ? "Normal" : bmi[i] < 29.9 ? "Overweight" : "Obese";
        }
        for (int i = 0; i < n; i++) System.out.println("Height: " + height[i] + ", Weight: " + weight[i] + ", BMI: " + bmi[i] + ", Status: " + status[i]);
    }
}
