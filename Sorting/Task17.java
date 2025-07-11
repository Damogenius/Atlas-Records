package Sorting;

import java.util.Arrays;

public class Task17 {


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];

        int i = low - 1;


        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] myList = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Original list: " + Arrays.toString(myList));

        quickSort(myList, 0, myList.length - 1);

        System.out.println("Sorted list: " + Arrays.toString(myList));
    }
}
