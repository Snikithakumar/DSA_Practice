class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the maximum diameter encountered so far
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
