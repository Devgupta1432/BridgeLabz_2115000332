
public class QuickSort {
    public static void main(String[] args) {
        double[] productPrices = {499.99, 159.75, 899.50, 249.99, 699.25};

        quickSort(productPrices, 0, productPrices.length - 1);

        System.out.println("Sorted Product Prices in Ascending Order:");
        for (double price : productPrices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }

    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}


