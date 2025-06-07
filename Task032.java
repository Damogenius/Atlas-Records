
class Calculation1 {
    int z;

    public void addition(int x, int y) {
        z = x + y;
        System.out.println("The sum of the given numbers: " + z);
    }

    public void Subtraction(int x, int y) {
        z = x - y;
        System.out.println("The difference between the given numbers: " + z);
    }
}

interface Clock {
    default void displayTime()
    {
        System.out.println("Displaying the time");
    }
}

public class Task032 extends My_Calculation3  {

    public static void main(String args[]) {
        int a = 20, b = 10;
        Task032 demo = new Task032();
        demo.addition(a, b);
        demo.Subtraction(a, b);
        demo.multiplication(a, b);
        demo.displayTime();
    }
}

class My_Calculation3 extends Calculation1 implements Clock{
    public void multiplication(int x, int y) {
        z = x * y;
        System.out.println("The product of the working given numbers: " + z);
    }

}
