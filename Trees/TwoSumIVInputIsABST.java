package Trees;

/**
 * LeetCode 653: Two Sum IV - Input is a BST
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class TwoSumIVInputIsABST {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        return dfs(root, k, seen);
    }

    private boolean dfs(TreeNode node, int k, java.util.Set<Integer> seen) {
        if (node == null) return false;
        if (seen.contains(k - node.val)) return true;
        seen.add(node.val);
        return dfs(node.left, k, seen) || dfs(node.right, k, seen);
    }
}
