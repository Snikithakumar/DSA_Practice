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
     * LeetCode #129 - Sum Root to Leaf Numbers
     *
     * You are given the root of a binary tree containing digits from 0 to 9 only.
     * Each root-to-leaf path represents a number. Return the total sum of all
     * root-to-leaf numbers.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree for recursion stack.
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        // Leaf node reached: return complete root-to-leaf number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
