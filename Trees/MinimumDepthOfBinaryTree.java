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
     * LeetCode #111 - Minimum Depth of Binary Tree
     *
     * Given a binary tree, find its minimum depth. The minimum depth is the number
     * of nodes along the shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf must have no children. If one child is null, we must traverse the
     * non-null child subtree to reach a valid leaf.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree for the recursion stack.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If left subtree is empty, shortest path to leaf must go through right subtree
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        // If right subtree is empty, shortest path to leaf must go through left subtree
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Both children exist: take minimum of both paths
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
