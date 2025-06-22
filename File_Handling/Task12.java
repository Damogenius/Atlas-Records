package File_Handling;

import java.util.ArrayList;

public class Task12 {
    public static void main(String[] args) {
        ArrayList<String> friends = new ArrayList<>();

        friends.add("Vicky");
        friends.add("Santho");
        friends.add("Yukesh");
        friends.add("Aravind");
        friends.add("Prakash");

        System.out.println("My friends are:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}