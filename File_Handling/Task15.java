package File_Handling;

import java.util.*;
import java.util.stream.Collectors;

public class Task15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter 5 integers:");
        for (int i = 0; i < 5; i++) {
            numbers.add(sc.nextInt());
        }

        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println("Squares of the numbers:");
        squares.forEach(System.out::println);
    }
}
