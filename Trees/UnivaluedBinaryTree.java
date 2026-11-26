package Trees;

/**
 * LeetCode 965: Univalued Binary Tree
 * https://leetcode.com/problems/univalued-binary-tree/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is tree height
 */
public class UnivaluedBinaryTree {
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

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return check(root, root.val);
    }

    private boolean check(TreeNode node, int val) {
        if (node == null) return true;
        if (node.val != val) return false;
        return check(node.left, val) && check(node.right, val);
    }
}
