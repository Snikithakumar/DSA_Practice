import java.util.ArrayList;
import java.util.List;

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
     * LeetCode #257 - Binary Tree Paths
     *
     * Given the root of a binary tree, return all root-to-leaf paths in any order.
     *
     * Recursive DFS Path Building:
     * Appends current node value to path and branches downwards. When a leaf node
     * is reached, the completed path string is added to the results.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(H) where H is the height of the tree for recursion stack.
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        dfs(root, Integer.toString(root.val), result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        // Leaf reached: collect completed path
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        if (node.left != null) {
            dfs(node.left, path + "->" + node.left.val, result);
        }

        if (node.right != null) {
            dfs(node.right, path + "->" + node.right.val, result);
        }
    }
}
