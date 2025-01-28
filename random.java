import java.util.Arrays;
public class random {
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = (int) (Math.random() * 9000) + 1000; // Generate 4-digit numbers (1000 to 9999)
        }
        return randomNumbers;
    }
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;
        for (int number : numbers) {
            sum += number;
            min = Math.min(min, number);
            max = Math.max(max, number);
        }
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }
    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);
        System.out.println("Generated Random Numbers: " + Arrays.toString(randomNumbers));
        double[] stats = findAverageMinMax(randomNumbers);
        System.out.printf("Average: %.2f\n", stats[0]);
        System.out.println("Minimum: " + (int) stats[1]);
        System.out.println("Maximum: " + (int) stats[2]);
    }
}
