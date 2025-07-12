package AVL;

class AVLTree {

    class Node {
        int data;
        Node left, right;
        int height;

        Node(int item) {
            data = item;
            left = right = null;
            height = 1;
        }
    }

    private Node root;


    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;


        x.right = y;
        y.left = T2;


        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;


        return x;
    }


    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;


        y.left = x;
        x.right = T2;


        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;


        return y;
    }

    Node insert(Node node, int key) {

        if (node == null)
            return new Node(key);

        if (key < node.data)
            node.left = insert(node.left, key);
        else if (key > node.data)
            node.right = insert(node.right, key);
        else
            return node;


        node.height = 1 + Math.max(height(node.left), height(node.right));


        int balance = getBalance(node);


        if (balance > 1 && key < node.left.data)
            return rightRotate(node);


        if (balance < -1 && key > node.right.data)
            return leftRotate(node);

        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
    }
}
    class Task02{


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        int[] valuesToInsert = {10, 20, 30, 15, 25, 5};

        for (int value : valuesToInsert) {
            System.out.println("Inserting: " + value);
            tree.insert(value);
            System.out.println("Tree after insertion of " + value + ":");
            tree.preOrder();
            System.out.println("\n---");
        }

        System.out.println("Final Preorder Traversal of the AVL Tree:");
        tree.preOrder();
    }
    }
