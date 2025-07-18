package Heap_Day_18;
import java.util.Scanner;
public class Task03 {

    public static int compute(int n,int sum){
        if(n==0)
        {
            return sum;
        }
        //count++;
        return compute(n/10,sum+1);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a Number: ");
        int a = sc.nextInt();
        int n=a;
        int sum=0,count=0;
        while(n!=0)
        {
            n=n/10;
            count++;
        }
        int rec=compute(a,sum);
        System.out.println("The number of digits in the number is : "+count);
        System.out.println("The number of digits in the number is : "+rec);

    }
}
