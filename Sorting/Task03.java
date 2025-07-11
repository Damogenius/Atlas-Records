package Sorting;

import java.util.Arrays;

public class Task03 {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i <= n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] myList = {64, 25, 12, 22, 11};
        System.out.println("Original list: " + Arrays.toString(myList));

        selectionSort(myList);

        System.out.println("Sorted list: " + Arrays.toString(myList));
    }
}
