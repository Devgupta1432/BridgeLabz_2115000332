import java.util.*;

public class SubsetCheck {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        boolean isSubset = checkSubset(set1, set2);
        System.out.println(isSubset);
    }

    public static boolean checkSubset(Set<Integer> subset, Set<Integer> superset) {
        return superset.containsAll(subset);
    }
}
