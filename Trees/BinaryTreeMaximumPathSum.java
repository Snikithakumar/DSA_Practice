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
    private int maxSum = Integer.MIN_VALUE;

    /**
     * LeetCode #124 - Binary Tree Maximum Path Sum
     *
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
     * has an edge connecting them. A node can only appear in the sequence at most once.
     * The path does not need to pass through the root.
     *
     * Returns the maximum path sum of any non-empty path.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree for recursion stack.
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively compute max gain from left and right subtrees; ignore negative contributions
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        // Path sum with the current node as the highest ancestor (turning point)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global maximum path sum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return maximum branch gain extending upwards to parent
        return node.val + Math.max(leftGain, rightGain);
    }
}
