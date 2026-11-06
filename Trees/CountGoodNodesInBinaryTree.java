/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     * LeetCode #1448 - Count Good Nodes in Binary Tree
     *
     * Given a binary tree root, a node X in the tree is named good if in the path
     * from the root to X there are no nodes with a value greater than X.
     *
     * Return the number of good nodes in the binary tree.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree for recursion stack.
     */
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countGood(root, root.val);
    }

    private int countGood(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        count += countGood(node.left, maxSoFar);
        count += countGood(node.right, maxSoFar);

        return count;
    }
}
