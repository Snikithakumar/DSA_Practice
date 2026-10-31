class Solution {
    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        answer = 0;
        inorder(root, k);
        return answer;
    }

    boolean inorder(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (inorder(root.left, k)) {
            return true;
        }

        count++;

        if (count == k) {
            answer = root.val;
            return true;
        }

        return inorder(root.right, k);
    }
}
