package Trees;

//class Node{
//    int data;
//    Node left,right;
//
//    Node(int data){
//        this.data=data;
//        left=right=null;
//    }
//
//}

class BinarySearchTree2{
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
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
}