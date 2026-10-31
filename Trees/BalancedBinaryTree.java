class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    // Helper method: returns the height of the subtree if balanced,
    // or -1 as a sentinel value if the subtree is unbalanced.
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        // Early exit if the left subtree is already unbalanced
        if (left == -1) {
            return -1;
        }

        int right = height(root.right);
        // Early exit if the right subtree is already unbalanced
        if (right == -1) {
            return -1;
        }

        // Current node is unbalanced if height difference exceeds 1
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height of current node
        return 1 + Math.max(left, right);
    }
}
