import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> rotatedList = rotateList(list, rotateBy);
        System.out.println(rotatedList);
    }

    public static List<Integer> rotateList(List<Integer> list, int k) {
        int size = list.size();
        k = k % size; 
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, size));
        rotated.addAll(list.subList(0, k));
        return rotated;
    }
}
