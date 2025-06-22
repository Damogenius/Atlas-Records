package File_Handling;

import java.util.ArrayList;
import java.util.List;

public class Task13 {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();

        friends.add("Vicky, Kumar");
        friends.add("Santho, Kumar");
        friends.add("Yukesh, Kumar");
        friends.add("Aravind, Kumar");
        friends.add("Prakash, Kumar");

        System.out.println("My friends are:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}