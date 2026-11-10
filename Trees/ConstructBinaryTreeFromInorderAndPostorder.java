import java.util.HashMap;
import java.util.Map;

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
    private int postorderIndex;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * LeetCode #106 - Construct Binary Tree from Inorder and Postorder Traversal
     *
     * Given two integer arrays inorder and postorder where inorder is the inorder
     * traversal of a binary tree and postorder is the postorder traversal of the same tree,
     * construct and return the binary tree.
     *
     * Time Complexity: O(N) where N is the number of nodes in the tree.
     * Space Complexity: O(N) for the HashMap and recursion stack.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderMap.clear();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return construct(postorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // Postorder traversal visits root last, so moving backwards picks the root of current subtree
        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderMap.get(rootVal);

        // Build right subtree before left subtree because postorder backward sequence is Root -> Right -> Left
        root.right = construct(postorder, mid + 1, right);
        root.left = construct(postorder, left, mid - 1);

        return root;
    }
}
