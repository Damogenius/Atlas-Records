package Sorting;

 class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;


    public ArrayStack(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push " + value);
        } else {
            stack[++top] = value;
            System.out.println("Pushed: " + value);
        }
    }


    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop");
            return -1;
        } else {
            int popped = stack[top--];
            System.out.println("Popped: " + popped);
            return popped;
        }
    }


    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top];
    }


    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (bottom to top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}
class Home_Task05{

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.printStack();

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        stack.pop();

        stack.printStack();
    }
}
