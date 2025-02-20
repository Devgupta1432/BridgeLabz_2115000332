import java.util.*;

public class CompareSets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        boolean isEqual = checkSetsEqual(set1, set2);
        System.out.println(isEqual);
    }

    public static boolean checkSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }
}
