package Methods_implementation.Strategy_method_Design;

import java.util.Scanner;

public class Dmanager_Main {
    public static void main(String[] args) {
        DManager manager = DManager.getInstance();
        Scanner sc= new Scanner(System.in);
        String input;
        String removedInput;
        System.out.println("Enter the input <Type Done to exit>");
        while(true)
        {
            input = sc.nextLine();
            if(input.equalsIgnoreCase("Done")) {
                System.out.println("Exiting");
                break;
            }
            manager.addItem(input);
        }

        System.out.println("Items: " + manager.list());
        System.out.println("Item to be removed: ");
        removedInput=sc.nextLine();
//        manager.removeItem(removedInput);
        if (manager.removeItem(removedInput)) {
            System.out.println("Removed: " + removedInput);
        } else {
            System.out.println("Item not found: " + removedInput);
        }
        System.out.println("Final Items: " + manager.list());
    }
}

