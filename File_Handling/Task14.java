package File_Handling;

import java.util.ArrayList;
import java.util.List;

public class Task14 {

    public static List<String> getFriends() {
        List<String> friends = new ArrayList<>();
        friends.add("Vicky, Kumar");
        friends.add("Santho, Kumar");
        friends.add("Yukesh, Kumar");
        friends.add("Aravind ");
        friends.add("Prakash, Kumar");
        return friends;
    }

    public static void main(String[] args) {
        List<String> myfriends = getFriends();
        System.out.println("Friends with Kumar as last name");

        myfriends.stream()
                .filter(p -> p.endsWith("Kumar"))
                .map(String::toLowerCase)
                .sorted()
                .forEach(System.out::println);
    }
}
