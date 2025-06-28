package LinkedList;

import java.util.*;

public class Task13 {
    public static void main(String[] args) {
        LinkedList<String> obj=new LinkedList<>();
        obj.push("First");
        obj.push("Last");
        obj.push("Middle");
        obj.push("Final last");
        obj.set(0,"New First");
        System.out.println(obj);
        obj.pop();
        System.out.println("After popping");
        System.out.println(obj);
    }
}

