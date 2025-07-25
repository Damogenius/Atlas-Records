package TestResults;

import java.util.*;

 class BinaryTree {

    private static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }


    static void rightView(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node right = null;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                right = current;

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }

            if (right != null)
                System.out.println(right.data + " ");
        }
    }

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int rootNode = sc.nextInt();
         Node root = new Node(rootNode);

         int left = sc.nextInt();
         root.left = new Node(left);

         int right = sc.nextInt();
         root.right = new Node(right);

         int leftLeft = sc.nextInt();
         root.left.left = new Node(leftLeft);

         int rightLeft = sc.nextInt();
         root.right.left = new Node(rightLeft);

         int rightRight = sc.nextInt();
         root.right.right = new Node(rightRight);

         int leftLeftLeft = sc.nextInt();
         root.left.left.left = new Node(leftLeftLeft);

         int rightLeftLeft = sc.nextInt();
         root.right.left.left = new Node(rightLeftLeft);

         int rightLeftRight = sc.nextInt();
         root.right.left.right = new Node(rightLeftRight);

         int rightRightRight = sc.nextInt();
         root.right.right.right = new Node(rightRightRight);

         rightView(root);

         sc.close();
     }
 }

