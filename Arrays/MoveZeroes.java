class Solution {
    /**
     * LeetCode #283 - Move Zeroes
     *
     * Given an integer array nums, move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.
     *
     * Two-pointer in-place write approach:
     * 1. Compact non-zero elements into the front of the array.
     * 2. Pad the remainder of the array with zeroes.
     *
     * Time Complexity: O(N) single pass through the array.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int insertPos = 0;

        // Shift all non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Fill remaining positions with zeroes
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}
