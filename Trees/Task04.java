package Trees;

class Node{
    int data;
    Node left,right;

    Node(int data){
        this.data=data;
        left=right=null;
    }

}

class BinarySearchTree{
    Node root;
    public void insert(int data) {
        root = insertRec(root, data);
    }
    private Node insertRec(Node root, int data) {
        if (root == null) {
            System.out.println("Inserted: " + data);
            return new Node(data);
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

    public void inorder(Node node) {
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
public class Task04 {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);
        tree.insert(10);
        tree.insert(20);
        tree.insert(35);
        System.out.println("Inorder Traversal");
        tree.inorder(tree.root);
    }
}
