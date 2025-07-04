package Linked_list_Day_2;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
 class Demo_CircularLinkedList {
    Node head;


    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("Circular Linked List: ");

        do {
            System.out.print(current.data + "-->");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head: " + head.data + ")");
    }
}
public class Task03{
    public static void main(String[] args) {
        Demo_CircularLinkedList list = new Demo_CircularLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.traverse();
    }
}

