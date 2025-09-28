package Methods_implementation.Strategy_method_Design;

import java.util.List;

public class Home_Task_Sorting {
    public static void main(String[] args) {
        SortingStrategy sorter = new SortingStrategy();

        // Add input items
        sorter.addItem("Stanford");
        sorter.addItem("Ankit");
        sorter.addItem("Watson");

        // Alphabetical Sorting
        System.out.println("Alpha sorting:");
        sorter.setStrategy(new AlphabeticalSortStrategy());
        List<String> alphaSorted = sorter.performSort();
        alphaSorted.forEach(System.out::println);

        // Lengthwise Sorting
        System.out.println("\nLengthwise sorting:");
        sorter.setStrategy(new LengthwiseSortStrategy());
        List<String> lengthSorted = sorter.performSort();
        lengthSorted.forEach(System.out::println);
    }
}
