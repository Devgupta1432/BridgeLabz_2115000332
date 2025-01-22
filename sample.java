import java.util.Scanner;

public class sample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter the city you are traveling from: ");
        String fromCity = input.nextLine();
        System.out.print("Enter the city you are traveling via: ");
        String viaCity = input.nextLine();
        System.out.print("Enter your final destination city: ");
        String toCity = input.nextLine();
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " (in miles): ");
        double fromToVia = input.nextDouble();
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " (in miles): ");
        double viaToFinalCity = input.nextDouble();
        System.out.print("Enter the time taken for the journey (in hours): ");
        double timeTaken = input.nextDouble();
        double totalDistance = fromToVia + viaToFinalCity;
        System.out.println("The total travel details for " + name + ":");
        System.out.println("From: " + fromCity + " to: " + viaCity + " to: " + toCity);
        System.out.println("The total distance covered is " + totalDistance + " miles.");
        System.out.println("The total time taken is " + timeTaken + " hours.");
    }
}
