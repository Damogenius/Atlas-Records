package Heap_Day_18;

import java.util.*;

public class Home_Task_20 {
    public static void main(String[] args) {

        int[] numbers = {45, 81, 85, 100, 20, 95, 60, 10, 21};


        List<List<Integer>> groups = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            groups.add(new ArrayList<>());
        }


        for (int num : numbers) {
            int unitDigit = num % 10;
            groups.get(unitDigit).add(num);
        }


        for (int i = 0; i < 10; i++) {
            if (!groups.get(i).isEmpty()) {
                System.out.print("Array " + (i + 1) + " has : ");
                for (int num : groups.get(i)) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}

