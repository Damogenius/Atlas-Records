package Linked_list_Day_2;

import java.util.Stack;

public class Task07 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Stack after pushes: " + stack);

        if (!stack.isEmpty()) {
            int topElement = stack.peek();
            System.out.println("Top element (peek): " + topElement);
        } else {
            System.out.println("The stack is empty. Nothing to peek.");
        }
    }
}