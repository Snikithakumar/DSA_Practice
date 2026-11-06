/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * LeetCode #236 - Lowest Common Ancestor of a Binary Tree
     *
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between
     * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow
     * a node to be a descendant of itself)."
     *
     * Time Complexity: O(N) where N is the number of nodes in the binary tree.
     * Space Complexity: O(H) where H is the height of the binary tree for the call stack.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: null root or matching target node
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search recursively in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right return non-null, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise return the non-null subtree result
        return left != null ? left : right;
    }
}
