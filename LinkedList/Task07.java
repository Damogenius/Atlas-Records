package LinkedList;

import java.util.*;

public class Task07 {
    public static void main(String[] args) {
        LinkedList<String> obj=new LinkedList<>();
        obj.add("First");
        obj.add("Last");
        obj.add(1,"Middle");
        obj.add("Final last");
        for(Object e:obj)
            System.out.printf("%s - > ",e);
        System.out.print("Null");
        obj.removeFirst();
        obj.removeLast();
        System.out.println("\nAfter removing the first and last values");
        obj.forEach(item -> System.out.print(item + " -> "));
        System.out.println("NULL");
    }
}

