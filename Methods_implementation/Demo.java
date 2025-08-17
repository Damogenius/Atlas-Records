package Methods_implementation;

public class Demo {
    public static void main(String[] args) {

        AppLogger logger1 = AppLogger.getInstance();
        logger1.log("This is the first message.");

        AppLogger logger2 = AppLogger.getInstance();
        logger2.log("This is the second message.");

        System.out.println("Are both logger instances same? " + (logger1 == logger2));
    }
}
