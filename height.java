import java.util.Scanner;

public class height {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightCm = input.nextDouble();
        double heightInches = heightCm / 2.54;
        int heightFeet = (int) (heightInches / 12);
        heightInches = heightInches % 12;
        System.out.print(
            "Your height in cm is "+heightCm +" while in feet is "+ heightFeet+" and inches is "+heightInches);
    }
}
