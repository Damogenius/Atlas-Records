package Linked_list_Day_2;

import java.util.Scanner;
public class Hometask_04 {

    public static String reverseString(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        scanner.close();

        String reversed = reverseString(input);

        System.out.println("Reversed String: " + reversed);
    }
}
