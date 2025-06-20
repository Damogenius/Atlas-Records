package Exception_handling;
class OuterClass2{
    int x = 50;
    class InnerClass1{
        public int innerMethod() {
            return x;
        }
    }
}
public class Task014 {
    public static void main(String[] args) {

        OuterClass2 myOuter = new OuterClass2();
        OuterClass2.InnerClass1 myInner = myOuter.new InnerClass1();
        System.out.println(myInner.innerMethod());
    }
}


