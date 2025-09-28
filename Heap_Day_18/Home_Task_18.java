package Heap_Day_18;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Solution {

    public void reverseAlternateLevels(TreeNode root) {
        if (root == null) return;
        reverseHelper(root.left, root.right, 1);
    }

    private void reverseHelper(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) return;

        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        reverseHelper(left.left, right.right, level + 1);
        reverseHelper(left.right, right.left, level + 1);
    }

    public void printLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("Level " + level + ": ");
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
            level++;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();

        System.out.println("Before reversing alternate levels:");
        sol.printLevelOrder(root);

        sol.reverseAlternateLevels(root);

        System.out.println("\nAfter reversing alternate levels:");
        sol.printLevelOrder(root);
    }
}
