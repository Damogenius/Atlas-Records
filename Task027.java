public class Task027 {
    public static void main(String args[])
    {
        int arr[] = { 3, 1, 2, 5, 4 };
        sum(arr);
    }
    public static void sum(int[] arr)
    {
        int sum = 0;
        for (int j : arr) sum += j;
        System.out.println("sum of array values : " + sum);
    }
}
