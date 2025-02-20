import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = countFrequency(list);

        System.out.println(frequencyMap);
    }

    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }
}
