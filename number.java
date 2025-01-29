import java.util.Scanner;

public class number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        boolean found = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Think of a number between 1 and 100.");

        while (!found) {
            int guess = generateGuess(lowerBound, upperBound);
            System.out.println("Is your number " + guess + "?");
            System.out.println("Enter '1' if my guess is too high, '2' if too low, '3' if correct:");

            int feedback = scanner.nextInt();
            switch (feedback) {
                case 1:
                    upperBound = guess - 1;
                    break;
                case 2:
                    lowerBound = guess + 1;
                    break;
                case 3:
                    found = true;
                    System.out.println("Great! I guessed your number.");
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1, 2, or 3.");
            }
        }
        scanner.close();
    }

    public static int generateGuess(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
    }
}

