class Solution {
    /**
     * LeetCode #189 - Rotate Array
     *
     * Given an integer array nums, rotate the array to the right by k steps,
     * where k is non-negative.
     *
     * In-place 3-reversal algorithm:
     * 1. Reverse the entire array.
     * 2. Reverse the first k elements.
     * 3. Reverse the remaining n - k elements.
     *
     * Time Complexity: O(N) where N is the length of nums.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;
        k %= n;

        if (k == 0) {
            return;
        }

        // Reverse entire array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining n - k elements
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
