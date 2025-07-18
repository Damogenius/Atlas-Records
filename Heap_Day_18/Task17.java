package Heap_Day_18;
import java.util.Arrays;

public class Task17 {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();


        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }


        System.arraycopy(output, 0, arr, 0, n);
    }


    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("Original Array: " + Arrays.toString(arr));

        radixSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
