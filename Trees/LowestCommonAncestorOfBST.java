class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            // Both targets lie in the left subtree
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            // Both targets lie in the right subtree
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            // Split point found: one target is on the left, one is on the right,
            // or current matches p or q. Thus, current is the lowest common ancestor.
            else {
                return current;
            }
        }

        return null;
    }
}
