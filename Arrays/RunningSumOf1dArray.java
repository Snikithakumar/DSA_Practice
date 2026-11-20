class Solution {
    /**
     * LeetCode #1480 - Running Sum of 1d Array
     *
     * Given an array nums, returns the running sum where runningSum[i] = sum(nums[0]...nums[i]).
     *
     * In-place prefix sum:
     * Accumulates preceding sum into each element: nums[i] += nums[i - 1].
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}
