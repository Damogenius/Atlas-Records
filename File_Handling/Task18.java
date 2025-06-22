package File_Handling;

import java.util.*;
import java.util.stream.Collectors;
public class Task18 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 22,33,33,22,44, 33, 44, 55, 60, 77);
        List<Integer> limitNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .toList();

        System.out.println("Limit numbers in the list[Top 10]:"+limitNumbers);
        //oddNumbers.forEach(System.out::println);
    }
}
