public class unit1 {
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        double fahrenheit2celsius = (fahrenheit - 32) * 5 / 9;
        return fahrenheit2celsius;
    }
    public static double convertCelsiusToFahrenheit(double celsius) {
        double celsius2fahrenheit = (celsius * 9 / 5) + 32;
        return celsius2fahrenheit;
    }
    public static double convertPoundsToKilograms(double pounds) {
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    public static double convertKilogramsToPounds(double kilograms) {
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    public static double convertGallonsToLiters(double gallons) {
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    public static double convertLitersToGallons(double liters) {
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
    public static void main(String[] args) {
        double fahrenheit = 98.6;
        double celsius = convertFahrenheitToCelsius(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit is equal to " + celsius + " Celsius.");
        celsius = 37;
        double convertedFahrenheit = convertCelsiusToFahrenheit(celsius);
        System.out.println(celsius + " Celsius is equal to " + convertedFahrenheit + " Fahrenheit.");
        double pounds = 150;
        double kilograms = convertPoundsToKilograms(pounds);
        System.out.println(pounds + " pounds is equal to " + kilograms + " kilograms.");
        kilograms = 68;
        double convertedPounds = convertKilogramsToPounds(kilograms);
        System.out.println(kilograms + " kilograms is equal to " + convertedPounds + " pounds.");
        double gallons = 5;
        double liters = convertGallonsToLiters(gallons);
        System.out.println(gallons + " gallons is equal to " + liters + " liters.");
        liters = 10;
        double convertedGallons = convertLitersToGallons(liters);
        System.out.println(liters + " liters is equal to " + convertedGallons + " gallons.");
    }
}
