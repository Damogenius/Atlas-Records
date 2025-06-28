package LinkedList;
import java.util.*;

public class Task06 {
    public static void main(String[] args) {
        LinkedList obj=new LinkedList();
        obj.add(30);
        obj.add(40);
        obj.add(1,50);
        for(Object e:obj)
            System.out.printf("%d - > ",e);
        System.out.print("Null");
        System.out.println("\nFirst element -> "+obj.getFirst());
        System.out.println("Last element -> "+obj.getLast());
        System.out.println("\n"+obj);
    }
}
