public class Sort {

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int N : sizes) {
            int[] arr1 = new int[N], arr2 = new int[N], arr3 = new int[N];
            for (int i = 0; i < N; i++) {
                int val = (int) (Math.random() * N);
                arr1[i] = val;
                arr2[i] = val;
                arr3[i] = val;
            }

            long start = System.nanoTime();
            bubbleSort(arr1);
            System.out.println("Bubble Sort: " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            mergeSort(arr2);
            System.out.println("Merge Sort: " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            quickSort(arr3, 0, N - 1);
            System.out.println("Quick Sort: " + (System.nanoTime() - start) / 1e6 + "ms");
        }
    }
}
