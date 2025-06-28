package LinkedList;

import java.util.*;

public class Task08 {
    public static void main(String[] args) {
        LinkedList<String> obj=new LinkedList<>();
        obj.add("First");
        obj.add("Last");
        obj.add(1,"Middle");
        obj.add("Final last");
        obj.set(0,"New First");
        obj.forEach(item -> System.out.print(item + " -> "));
        System.out.println("NULL");
    }
}

