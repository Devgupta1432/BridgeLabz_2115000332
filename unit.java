public class unit {
    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }
    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
    public static void main(String[] args) {
        double yards = 5;
        double feet = convertYardsToFeet(yards);
        System.out.println(yards + " yards is equal to " + feet + " feet.");
        feet = 15;
        double convertedYards = convertFeetToYards(feet);
        System.out.println(feet + " feet is equal to " + convertedYards + " yards.");
        double meters = 10;
        double inches = convertMetersToInches(meters);
        System.out.println(meters + " meters is equal to " + inches + " inches.");
        inches = 100;
        double convertedMeters = convertInchesToMeters(inches);
        System.out.println(inches + " inches is equal to " + convertedMeters + " meters.");
        inches = 20;
        double centimeters = convertInchesToCentimeters(inches);
        System.out.println(inches + " inches is equal to " + centimeters + " centimeters.");
    }
}
