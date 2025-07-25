package TestResults;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

 public class Binary_Alternate {

     public static void invertBinaryTree(Node root) {
         Queue<Node> queue = new LinkedList<>();
         queue.add(root);
         boolean evenLevel = false;

         while (!queue.isEmpty()) {
             int size = queue.size();
             List<Node> level = new ArrayList<>();

             for (int i = 0; i < size; i++) {
                 Node current = queue.poll();
                 level.add(current);

                 if (current.left != null) {
                     queue.add(current.left);
                 }

                 if (current.right != null) {
                     queue.add(current.right);
                 }
             }

             if (evenLevel) {
                 int left = 0, right = level.size() - 1;

                 while (left < right) {
                     int temp = level.get(left).data;
                     level.get(left).data = level.get(right).data;
                     level.get(right).data = temp;
                     left++;
                     right--;
                 }
             }

             evenLevel = !evenLevel;
         }
     }

     public static void levelOrderTraversal(Node root) {
         if (root == null)
             return;

         Queue<Node> queue = new LinkedList<>();
         queue.add(root);

         while (!queue.isEmpty()) {
             Node current = queue.poll();
             System.out.print(current.data + " ");

             if (current.left != null)
                 queue.add(current.left);
             if (current.right != null)
                 queue.add(current.right);
         }
         System.out.println();
     }

     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         int rootNode = scanner.nextInt();
         Node root = new Node(rootNode);

         int rootLeft = scanner.nextInt();
         root.left = new Node(rootLeft);

         int rootRight = scanner.nextInt();
         root.right = new Node(rootRight);

         int rootLeftLeft = scanner.nextInt();
         root.left.left = new Node(rootLeftLeft);

         int rootLeftRight = scanner.nextInt();
         root.left.right = new Node(rootLeftRight);

         int rootRightLeft = scanner.nextInt();
         root.right.left = new Node(rootRightLeft);

         int rootRightRight = scanner.nextInt();
         root.right.right = new Node(rootRightRight);

         int rootLeftLeftLeft = scanner.nextInt();
         root.left.left.left = new Node(rootLeftLeftLeft);

         int rootLeftLeftRight = scanner.nextInt();
         root.left.left.right = new Node(rootLeftLeftRight);

         int rootLeftRightLeft = scanner.nextInt();
         root.left.right.left = new Node(rootLeftRightLeft);

         int rootLeftRightRight = scanner.nextInt();
         root.left.right.right = new Node(rootLeftRightRight);

         int rootRightLeftLeft = scanner.nextInt();
         root.right.left.left = new Node(rootRightLeftLeft);

         int rootRightLeftRight = scanner.nextInt();
         root.right.left.right = new Node(rootRightLeftRight);

         int rootRightRightLeft = scanner.nextInt();
         root.right.right.left = new Node(rootRightRightLeft);

         int rootRightRightRight = scanner.nextInt();
         root.right.right.right = new Node(rootRightRightRight);

         invertBinaryTree(root);
         levelOrderTraversal(root);
     }
 }
