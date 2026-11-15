class Solution {
    /**
     * LeetCode #27 - Remove Element
     *
     * Given an integer array nums and an integer val, remove all occurrences of val
     * in nums in-place, returning the number of elements not equal to val.
     *
     * Two-pointer in-place compaction:
     * Copies non-matching elements to the front pointer k.
     *
     * Time Complexity: O(N) single pass through nums.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int k = 0;

        for (int num : nums) {
            if (num != val) {
                nums[k++] = num;
            }
        }

        return k;
    }
}
