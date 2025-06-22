package File_Handling;

import java.lang.FunctionalInterface;

// this is functional interface
@FunctionalInterface
interface MyInterface{
    double getPiValue();
}
public class Task09 {

    public static void main( String[] args ) {
        MyInterface ref;
        ref = () -> 3.1415;

        System.out.println("Value of Pi = " + ref.getPiValue());
    }
}
