import java.util.Arrays;

public class Linear {
    
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, -1, 1, 5, 6};
        int target = 4;

        int missingPositive = findFirstMissingPositive(numbers);
        System.out.println("First missing positive integer: " + missingPositive);

        Arrays.sort(numbers);
        int targetIndex = binarySearch(numbers, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}
