import java.util.*;

class Solution {

    int preorderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        preorderIndex = 0;
        inorderMap.clear();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    TreeNode construct(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int mid = inorderMap.get(rootValue);

        root.left = construct(preorder, left, mid - 1);
        root.right = construct(preorder, mid + 1, right);

        return root;
    }
}
