import java.util.Scanner;
public class triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base of the triangle in inches: ");
        double baseInches = input.nextDouble();
        System.out.print("Enter the height of the triangle in inches: ");
        double heightInches = input.nextDouble();
        double areaInInches = 0.5 * baseInches * heightInches;
        double areaInCm = areaInInches * 6.4516; 
        System.out.println("The area of the triangle is "+areaInInches+" square inches and "+areaInCm+" square centimeters.");
    }
}
