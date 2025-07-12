package Trees;

class Node3{
    int data;
    Node3 left,right;

    Node3(int data){
        this.data=data;
        left=right=null;
    }

}

class BinarySearchTree3 {
    Node3 root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node3 insertRec(Node3 root, int data) {
        if (root == null) {
            System.out.println("Inserted: " + data);
            return new Node3(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        } else {
            System.out.println("Duplicate not allowed: " + data);
        }
        return root;
    }

    //    public void display() {
//        System.out.print("Inorder Traversal: ");
//        inorder(root);
//        System.out.println();
//    }
    public Node3 search(int key) {
        Node3 current = root;
        while (current != null) {        //	key 30    current 50 == root
            if (key == current.data) {
                return current;
            } else if (key < current.data) {        //	key 80    current 50 == root
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }


    public void inorder(Node3 node) {
        //System.out.println("Inorder Traversal:");
        if (node != null) {
            System.out.println("Visiting left child of " + node.data);
            inorder(node.left);
            System.out.println("Visiting node: " + node.data);
            inorder(node.right);
//        if (node != null) {
//            inorder(node.left);
//            System.out.print(node.data + " ");
//            inorder(node.right);
        }
    }
}
public class Task06 {
    public static void main(String[] args) {
        BinarySearchTree3 tree = new BinarySearchTree3();
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(10);
        tree.insert(20);
        tree.insert(35);
        Node3 foundNode = tree.search(50);
        if (foundNode != null) {
            System.out.println("Found: " + foundNode.data);
        } else {
            System.out.println("Not Found.");
        }

    }
}
