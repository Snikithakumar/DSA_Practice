package Trees;

/**
 * LeetCode 872: Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Time Complexity: O(T1 + T2)
 * Space Complexity: O(H1 + H2)
 */
public class LeafSimilarTrees {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        java.util.List<Integer> leaves1 = new java.util.ArrayList<>();
        java.util.List<Integer> leaves2 = new java.util.ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode node, java.util.List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }
        getLeaves(node.left, leaves);
        getLeaves(node.right, leaves);
    }
}
