package Methods_implementation.Strategy_method_Design;

public class Dmanager_Main {
    public static void main(String[] args) {
        DManager manager = DManager.getInstance();

        manager.addItem("Apple");
        manager.addItem("Orange");

        System.out.println("Items: " + manager.list());

        manager.removeItem("Apple");
        System.out.println("After removal: " + manager.list());
    }
}

