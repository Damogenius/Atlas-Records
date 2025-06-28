package LinkedList;

import java.util.*;

public class Task09 {
    public static void main(String[] args) {
        LinkedList<String> obj=new LinkedList<>();
        obj.add("First");
        obj.add("Last");
        obj.add(1,"Middle");
        obj.add("Final last");
        obj.set(0,"New First");

        for(int i = 0; i < obj.size(); i++) {
            System.out.print(obj.get(i) + " -> ");
        }
        System.out.println("NULL");

        obj.forEach(item -> System.out.print(item + " -> "));
        System.out.println("NULL");
    }
}

