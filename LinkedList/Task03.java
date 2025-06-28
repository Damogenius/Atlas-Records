package LinkedList;

class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

class Linkedlist {
    private Node head;

    public Linkedlist() {
        head = null;
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class Task03 {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.print("Linked List: ");
        list.display();

        list.deleteByValue(20);

        System.out.print("After Deleting 20: ");
        list.display();
    }
}

