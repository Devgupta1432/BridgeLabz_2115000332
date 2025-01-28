import java.util.Arrays;
public class football {
    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = (int) (Math.random() * 101) + 150; // Generate heights between 150 and 250 cm
        }
        return heights;
    }
    public static int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }
    public static double findMean(int[] heights) {
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }
    public static int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }
    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }
    public static void main(String[] args) {
        int teamSize = 11;
        int[] heights = generateRandomHeights(teamSize);
        System.out.println("Heights of Players: " + Arrays.toString(heights));
        double meanHeight = findMean(heights);
        int shortestHeight = findShortest(heights);
        int tallestHeight = findTallest(heights);
        System.out.printf("Mean Height: %.2f cm\n", meanHeight);
        System.out.println("Shortest Height: " + shortestHeight + " cm");
        System.out.println("Tallest Height: " + tallestHeight + " cm");
    }
}
