import java.util.Scanner;

public class temp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1: Celsius to Fahrenheit");
        System.out.println("2: Fahrenheit to Celsius");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        if (choice == 1) {
            System.out.println("Converted Temperature: " + celsiusToFahrenheit(temperature) + " °F");
        } else if (choice == 2) {
            System.out.println("Converted Temperature: " + fahrenheitToCelsius(temperature) + " °C");
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}


