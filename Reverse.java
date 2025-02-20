import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Reverse {

    public static void main(String[] args) {
        // Reverse ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        reverseArrayList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        // Reverse LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        reverseLinkedList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    public static void reverseArrayList(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }

    public static void reverseLinkedList(LinkedList<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Integer temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }
}
