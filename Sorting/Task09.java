package Sorting;

import java.util.Arrays;

public class Task09 {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] myList = {29, 10, 14, 37, 13};
        System.out.println("Original list: " + Arrays.toString(myList));

        insertionSort(myList);

        System.out.println("Sorted list: " + Arrays.toString(myList));
    }
}
