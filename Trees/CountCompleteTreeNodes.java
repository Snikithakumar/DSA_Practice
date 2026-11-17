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
     * LeetCode #222 - Count Complete Tree Nodes
     *
     * Given the root of a complete binary tree, return the number of nodes in the tree.
     *
     * In a complete binary tree:
     * If the left-most depth equals the right-most depth, the tree is a full binary tree
     * with exactly (2^depth - 1) nodes.
     * Otherwise, recursively count nodes in left and right subtrees.
     *
     * Time Complexity: O(log^2 N) where N is the number of nodes.
     * Space Complexity: O(log N) for the recursion call stack.
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getLeftDepth(root);
        int rightDepth = getRightDepth(root);

        // Full binary tree condition
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getLeftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }

    private int getRightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}
