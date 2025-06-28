package LinkedList;

import java.util.*;

public class Task14 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // ArrayList instead of LinkedList
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        System.out.println("Spliterator 1:");
        spliterator1.forEachRemaining(System.out::println);

        System.out.println("Spliterator 2:");
        if (spliterator2 != null)
            spliterator2.forEachRemaining(System.out::println);
    }
}
