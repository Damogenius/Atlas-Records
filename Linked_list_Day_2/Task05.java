package Linked_list_Day_2;

import java.util.Stack;

public class Task05 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Stack after pushes: " + stack);
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack currently: " + stack);
    }
}
