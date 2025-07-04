package Linked_list_Day_2;

 class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}
class CircularLinkedList {
    Node1 head;


    public void insert(int data) {
        Node1 newNode = new Node1(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node1 current = head;
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

        Node1 current = head;
        System.out.print("Circular Linked List: ");

        do {
            System.out.print(current.data + "-->");
            current = current.next;
        } while (current != head);

        System.out.println("(back to head: " + head.data + ")");
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        Node1 current = head;
        Node1 prev = null;

        if (head.data == key) {

            if (head.next == head) {
                head = null;
                return;
            }

            Node1 last = head;
            while (last.next != head) {
                last = last.next;
            }

            head = head.next;
            last.next = head;
            return;
        }

        do {
            prev = current;
            current = current.next;

            if (current.data == key) {
                prev.next = current.next;
                return;
            }
        } while (current != head);

        System.out.println("Node with value " + key + " not found.");
    }

}



public class Task04{
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.traverse();
        list.delete(30);
        list.traverse();
        list.delete(100);
        list.traverse();
    }
}

