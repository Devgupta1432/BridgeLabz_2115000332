
public class BubbleSort {
    public static void main(String[] args) {
        int[] studentMarks = {87, 56, 92, 78, 68, 85};

        bubbleSort(studentMarks);

        System.out.println("Sorted student marks in ascending order:");
        for (int mark : studentMarks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}


