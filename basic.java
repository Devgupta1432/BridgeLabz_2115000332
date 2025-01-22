import java.util.Scanner;

public class basic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();
        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.printf(
            "The addition, subtraction, multiplication, and division values of the numbers "+number1+" and "+number2+" are %.2f, %.2f, %.2f, and %.2f respectively.",
            addition, subtraction, multiplication, division
        );
    }
}
