package File_Handling;

import java.util.*;
import java.util.stream.Collectors;

public class Task17 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 22,33,33,22,44, 33, 44, 55, 60, 77);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();

        System.out.println("Unique numbers in the list:"+uniqueNumbers);
        //oddNumbers.forEach(System.out::println);
    }
}
