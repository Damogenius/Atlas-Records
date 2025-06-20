package Exception_handling;

class OuterClass1 {
    int x = 10;
    static class InnerClass {
        int y = 5;
    }
}

public class Task013 {
    public static void main(String[] args) {
        OuterClass1 myOuter = new OuterClass1();
        OuterClass1.InnerClass myInner = new OuterClass1.InnerClass();
        System.out.println(myInner.y + myOuter.x);
    }
}


