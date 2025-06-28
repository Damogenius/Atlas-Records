package LinkedList;

class Node1<T> {
    T data;
    Node1<T> next;

    Node1(T value) {
        data = value;
        next = null;
    }
}

class LinkedList1<T> {
    private Node1<T> head;
    int size;

    // Constructor
    public LinkedList1() {
        head = null;
        size=0;
    }

    public void insertAtEnd(T value) {
        Node1<T> newNode = new Node1<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node1<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }

    public void deleteByValue(T value) {
        if (head == null) return;

        if (head.data.equals(value)) {
            head = head.next;
            size--;
            return;
        }

        Node1<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(value)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            size--;
        }
    }

    public void display() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
        Node1<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public int getSize() {
        return size;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node1<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }
}


public class Task04 {
    public static void main(String[] args) {
        // Integer LinkedList
//        LinkedList1<Integer> intList = new LinkedList1<Integer>();
//        intList.insertAtEnd(10);
//        intList.insertAtEnd(20);
//        intList.display();
//        intList.deleteByValue(10);
//        intList.display();
//
//        // String LinkedList
//        LinkedList1<String> stringList = new LinkedList1<String>();
//        stringList.insertAtEnd("Apple");
//        stringList.insertAtEnd("Banana");
//        stringList.display();
//        stringList.deleteByValue("Apple");
//        stringList.display();
        LinkedList1<String> list = new LinkedList1<String>();

        list.insertAtEnd("Apple");
        list.insertAtEnd("Banana");
        list.insertAtEnd("Cherry");


        System.out.print("List: ");
        list.display();


        list.deleteByValue("Banana");

        System.out.print("After Deleting 'Banana': ");
        list.display();

        System.out.println("Size of the list: " + list.getSize());

        try {
            System.out.println("Element at index 1: " + list.get(1));
            System.out.println("Element at index 5: " + list.get(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

