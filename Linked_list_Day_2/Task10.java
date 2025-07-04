package Linked_list_Day_2;

class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

    class CustomQueue {
        Node2 front, rear;

        public void enqueue(int data) {
            Node2 newNode = new Node2(data);

            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            System.out.println("Enqueued: " + data);
        }

        public int dequeue() {
            if (front == null) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }

            int removedData = front.data;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            System.out.println("Dequeued: " + removedData);
            return removedData;
        }

        public int peek() {
            if (front == null) {
                System.out.println("Queue is empty. Nothing to peek.");
                return -1; // Or throw an exception if preferred
            }
            System.out.println("Peek: " + front.data);
            return front.data;
        }

        public boolean empty() {
            if (front == null) {
                System.out.println("Queue is empty.");
                return true;
            } else {
                System.out.println("Queue is not empty.");
                return false;
            }
        }


            public void display () {
                if (front == null) {
                    System.out.println("Queue is empty.");
                    return;
                }

                Node2 current = front;
                System.out.print("Queue: ");
                while (current != null) {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }

public class Task10{
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.empty();
        queue.display();
        queue.peek();
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
