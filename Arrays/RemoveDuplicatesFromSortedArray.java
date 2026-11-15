class Solution {
    /**
     * LeetCode #26 - Remove Duplicates from Sorted Array
     *
     * Given an integer array nums sorted in non-decreasing order, remove duplicates
     * in-place such that each unique element appears only once.
     *
     * Two-pointer in-place write approach:
     * Maintains an insert position for unique elements, advancing when a new
     * distinct value is encountered.
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int insertPos = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[insertPos++] = nums[i];
            }
        }

        return insertPos;
    }
}
