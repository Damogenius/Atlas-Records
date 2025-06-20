package Exception_handling;

class OuterClass3 {
    int x = 10;
    static class InnerClass {
        static int y = 5;
    }
}
public class Task015 {
    public static void main(String[] args) {
        OuterClass3.InnerClass myInner = new OuterClass3.InnerClass();
        System.out.println(myInner.y);

    }
}
