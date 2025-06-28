package LinkedList;

class Node2<T> {
    T data;
    Node2<T> prev;
    Node2<T> next;
    Node2(T value)
    {
        data=value;
        next=null;
        prev=null;
    }
}
class DoublyLinkedlist<T>{
    Node2<T> head;
    Node2<T> tail;

    public void insertAtEnd(T value)
    {
        Node2<T> newNode = new Node2<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
    }
}

    public void deleteByValue(T value) {
        if (head == null) return;
        Node2<T> current = head;
        while (current != null && !current.data.equals(value)) {
            current = current.next;
        }
        if (current == null) return;
        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void displayForward() {
        Node2<T> temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void displayBackward() {
        Node2<T> temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }
}

public class Task16 {
    public static void main(String[] args) {
        DoublyLinkedlist<String> list = new DoublyLinkedlist<>();
        list.insertAtEnd("One");
        list.insertAtEnd("Two");
        list.insertAtEnd("Three");
        list.displayForward();
        list.displayBackward();
        list.deleteByValue("Two");
        list.displayForward();
        list.displayBackward();
    }
}

