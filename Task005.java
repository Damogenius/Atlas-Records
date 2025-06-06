public class Task005 {
    static int b = 11;
    static int a = 10;

    public static void main(String[] args) {
        Task005 obj = new Task005();
        obj.add();
        obj.subtract();
        obj.Multiply();
        obj.divide();

    }

    public void add() {
        int c = a + b;
        System.out.println("Addition of two numbers= " + c);
    }

    public void subtract() {
        int c = a - b;
        System.out.println("Subtraction of two numbers= " + c);
    }

    public void Multiply() {
        int c = a * b;
        System.out.println("Multiplication of two numbers= " + c);
    }
    public void divide() {
        int c = a / b;
        System.out.println("Division of two numbers= " + c);
    }
}