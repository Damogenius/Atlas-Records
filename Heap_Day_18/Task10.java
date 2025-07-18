package Heap_Day_18;

import java.util.*;

class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void printLeftRightNodes(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level=0;

        while (!queue.isEmpty()) {
            int nodeCount = queue.size();

            Node leftMost = null;
            Node rightMost = null;

            for (int i = 0; i < nodeCount; i++) {
                Node currentNode = queue.poll();

                if (i == 0) leftMost = currentNode;
                if (i == nodeCount - 1) rightMost = currentNode;

                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
            if(level==0)
            {
                System.out.println("root: "+root.data);
            }
            else {
                System.out.println("Level nodes: Leftmost = " + leftMost.data + ", Rightmost = " + rightMost.data);
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        printLeftRightNodes(root);
    }
}
