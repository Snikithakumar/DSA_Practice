class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // An empty subRoot is always a subtree
        if (subRoot == null) {
            return true;
        }

        // If root is empty but subRoot is not, it cannot be a subtree
        if (root == null) {
            return false;
        }

        // If current subtrees are identical, return true
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise check whether subRoot exists in the left or right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        // Both nodes null: structural match
        if (p == null && q == null) {
            return true;
        }

        // Exactly one node null: structural mismatch
        if (p == null || q == null) {
            return false;
        }

        // Different node values: value mismatch
        if (p.val != q.val) {
            return false;
        }

        // Recursively compare left and right children
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
