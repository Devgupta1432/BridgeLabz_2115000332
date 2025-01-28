import java.util.Scanner;
public class bmi {
    public static double calculateBMI(double weight, double heightInCm) {
        double heightInM = heightInCm / 100;  
        return weight / (heightInM * heightInM);
    }
    public static String determineStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] data = new double[10][3]; 
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = scanner.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }
        System.out.println("\nBMI and Status of Each Individual:");
        for (int i = 0; i < 10; i++) {
            String status = determineStatus(data[i][2]);
            System.out.printf("Person %d: Weight = %.2f kg, Height = %.2f cm, BMI = %.2f, Status = %s\n",
                    i + 1, data[i][0], data[i][1], data[i][2], status);
        }
        scanner.close();
    }
}
