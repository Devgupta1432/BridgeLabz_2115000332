import java.util.*;

public class DSsearchComparisoin {

    public static boolean searchArray(int[] arr, int target) {
        for (int i : arr) {
            if (i == target) return true;
        }
        return false;
    }

    public static boolean searchHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static boolean searchTreeSet(TreeSet<Integer> set, int target) {
        return set.contains(target);
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        for (int N : sizes) {
            int[] array = new int[N];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < N; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            long start = System.nanoTime();
            searchArray(array, N - 1);
            System.out.println("Array Search for N=" + N + ": " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            searchHashSet(hashSet, N - 1);
            System.out.println("HashSet Search for N=" + N + ": " + (System.nanoTime() - start) / 1e6 + "ms");

            start = System.nanoTime();
            searchTreeSet(treeSet, N - 1);
            System.out.println("TreeSet Search for N=" + N + ": " + (System.nanoTime() - start) / 1e6 + "ms");
        }
    }
}
