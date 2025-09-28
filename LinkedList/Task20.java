package LinkedList;

import java.util.HashMap;

public class Task20 {
    public static void main(String[] args) {

        HashMap<String, Integer> defaultMap = new HashMap<>();
        defaultMap.put("Apple", 10);
        defaultMap.put("Banana", 20);
        defaultMap.put("Orange", 30);
        System.out.println("HashMap with Default Capacity (16) and Load Factor (0.75): " + defaultMap);
        HashMap<String, Integer> mapWithCapacity10 = new HashMap<>(10);
        mapWithCapacity10.put("Mango", 40);
        mapWithCapacity10.put("Peach", 50);
        System.out.println("HashMap with Capacity 10: " + mapWithCapacity10);
        HashMap<String, Integer> copiedMap = new HashMap<>(defaultMap);
        System.out.println("Copied HashMap: " + copiedMap);

        HashMap<String, Integer> mapWithCustomLoadFactor = new HashMap<>(10, 0.8f);
        mapWithCustomLoadFactor.put("Grapes", 60);
        mapWithCustomLoadFactor.put("Watermelon", 70);
        System.out.println("HashMap with Capacity 10 and Load Factor 0.8: " + mapWithCustomLoadFactor);
    }
}
