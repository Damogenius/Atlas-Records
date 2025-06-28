package LinkedList;
import java.util.HashMap;

public class Task18 {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Apple", 1);
        map1.put("Banana", 2);
        map1.put("Cherry", 3);
        HashMap<String, Integer> map2 = new HashMap<>(map1);
        //map2.putAll(map1);
        System.out.println("Original Map (map1): " + map1);
        System.out.println("Copied Map (map2): " + map2);
    }
}
