package Linked_list_Day_2;

import java.util.Stack;

public class Task06 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Stack after pushes: " + stack);
        int element = 20;
        int position = stack.search(element);

        if (position == -1) {
            System.out.println("Element " + element + " not found in the stack.");
        } else {
            System.out.println("Element " + element + " is at position " + position + " from the top.");
        }
    }
}
