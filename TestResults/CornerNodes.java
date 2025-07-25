package TestResults;

import java.util.*;

 class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

 class CornerNodes {

    public static void print(Node1 root) {
        if (root == null)
            return;

        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node1 current = queue.poll();


                if (i == 0 || i == size - 1) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            System.out.println();
        }
    }

     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

         int rootNode = sc.nextInt();
         Node1 root = new Node1(rootNode);

         int left = sc.nextInt();
         root.left = new Node1(left);

         int right = sc.nextInt();
         root.right = new Node1(right);

         int leftLeft = sc.nextInt();
         root.left.left = new Node1(leftLeft);
         int leftRight = sc.nextInt();
         root.left.right = new Node1(leftRight);
         int rightLeft = sc.nextInt();
         root.right.left = new Node1(rightLeft);
         int rightRight = sc.nextInt();
         root.right.right = new Node1(rightRight);
         int leftLeftLeft = sc.nextInt();
         root.left.left.left = new Node1(leftLeftLeft);
         int rightLeftLeft = sc.nextInt();
         root.right.left.left = new Node1(rightLeftLeft);
         int rightLeftRight = sc.nextInt();
         root.right.left.right = new Node1(rightLeftRight);
         int rightRightRight = sc.nextInt();
         root.right.right.right = new Node1(rightRightRight);

         print(root);

         sc.close();
     }
  }