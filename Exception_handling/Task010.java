package Exception_handling;
import java.util.*;

public class Task010 {
    public static void main(String args[]){
        ArrayList<String> al = new ArrayList<>();
        al.add("Damo");
        al.add("KT");
        System.out.println("Original List : "+al);

        al.add(1, "Hello");
        System.out.println("After Adding element at index 1 : "+ al);

        al.remove(0);
        System.out.println("Element removed from index 0 : "+ al);

        al.remove("Damo");
        System.out.println("Element Damo removed : "+ al);

        al.set(0, "D");
        System.out.println("List after updation of value : "+al);
    }

}
