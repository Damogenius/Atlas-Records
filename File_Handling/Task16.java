package File_Handling;

import java.util.*;
import java.util.stream.Collectors;
public class Task16 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 22, 33, 44, 55, 60, 77);


        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .toList();

        System.out.println("Odd numbers in the list:");
        oddNumbers.forEach(n ->System.out.print(" "+n));
    }
}