package LinkedList;

class Node3 {
    int data;
    Node3 next;

    Node3(int value) {
        data = value;
        next = null;
    }
}

class CircularLinkedList {
    private Node3 tail;

    // Insert node at the end
    public void insert(int value) {
        Node3 newNode = new Node3(value);
        if (tail == null) {
            tail = newNode;
            tail.next = tail; // Points to itself
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void display() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }
        Node3 temp = tail.next;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != tail.next);
        System.out.println("(back to head)");
    }
}
public class Task21 {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(10);
        cll.insert(20);
        cll.insert(30);
        cll.insert(40);
        cll.insert(50);

        cll.display();
    }
}
