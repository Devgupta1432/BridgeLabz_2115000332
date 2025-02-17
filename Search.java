public class Search {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == target) return i;
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int N : sizes) {
            int[] arr = new int[N];
            for (int i = 0; i < N; arr[i++] = i); 
            long start = System.nanoTime();
            linearSearch(arr, -1);
            System.out.println("Linear: " + (System.nanoTime() - start) / 1e6 + "ms");
            start = System.nanoTime();
            binarySearch(arr, -1);
            System.out.println("Binary: " + (System.nanoTime() - start) / 1e6 + "ms");
        }
    }
}

