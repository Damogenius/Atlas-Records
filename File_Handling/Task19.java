package File_Handling;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Task19 {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 22,33,33,22,44, 33, 44, 55, 60, 77);
        Stream<Integer> nums = Stream
                .iterate(1, n -> n + 1)
                .limit(20);
        Stream<Integer> skipNums = nums.skip(15);
        System.out.println("Numbers after skipping first 15:");
        //System.out.println(skipNums);
        skipNums.forEach(n ->System.out.print(" "+n));
        //oddNumbers.forEach(System.out::println);
    }
}
