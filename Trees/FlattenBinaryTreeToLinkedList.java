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
     * LeetCode #114 - Flatten Binary Tree to Linked List
     *
     * Given the root of a binary tree, flatten the tree into a "linked list"
     * following pre-order traversal order using the TreeNode structure.
     *
     * In-place Morris-style traversal:
     * For each node with a left child, find the rightmost node of the left subtree,
     * connect the original right subtree to it, and move the left subtree to the right.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public void flatten(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }

                // Splice the right subtree into the predecessor's right
                predecessor.right = curr.right;
                // Move the left subtree to the right
                curr.right = curr.left;
                curr.left = null;
            }

            // Move to the next node on the right spine
            curr = curr.right;
        }
    }
}
