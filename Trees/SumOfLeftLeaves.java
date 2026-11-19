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
     * LeetCode #404 - Sum of Left Leaves
     *
     * Given the root of a binary tree, return the sum of all left leaves.
     * A left leaf is a leaf node (no children) that is specifically the left child of its parent.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree for recursion stack.
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        // Leaf node check: return value only if it is a left child
        if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        }

        return dfs(node.left, true) + dfs(node.right, false);
    }
}
