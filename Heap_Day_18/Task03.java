package Heap_Day_18;
import java.util.Scanner;
public class Task03 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int a = sc.nextInt();
        int n=a;
        int count=0;
        while(n!=0)
        {
            n=n/10;
            count++;
        }
        System.out.println("The number of digits in the number is : "+count);

    }
}
