package Trees;

/**
 * LeetCode 938: Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(H) where H is tree height
 */
public class RangeSumOfBST {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
