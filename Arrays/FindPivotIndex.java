class Solution {
    /**
     * LeetCode #724 - Find Pivot Index
     *
     * Given an array of integers nums, calculate the pivot index of this array.
     * The pivot index is the index where the sum of numbers to the left equals
     * the sum of numbers to the right.
     *
     * Prefix Sum Equation:
     * leftSum == totalSum - leftSum - nums[i]
     *
     * Time Complexity: O(N) two linear passes.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Right sum = totalSum - leftSum - nums[i]
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
