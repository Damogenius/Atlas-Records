package LinkedList;

import java.util.*;

public class Task12 {
    public static void main(String[] args) {
        LinkedList<String> obj=new LinkedList<>();
        obj.add("First");
        obj.add("Last");
        obj.add(1,"Middle");
        obj.add("Final last");
        obj.set(0,"New First");

        LinkedList obj2=(LinkedList) obj.clone();
        System.out.println("Original : " +obj);
        System.out.println("Clone : " +obj2);
        obj.remove("Middle");
        System.out.println("After removing a element from the Original");
        System.out.println("Original : " +obj);
        System.out.println("Clone : " +obj2);
        obj2.pop();
        System.out.println(obj2);
    }
}

