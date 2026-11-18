class Solution {
    /**
     * LeetCode #268 - Missing Number
     *
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * Arithmetic Sum Formula:
     * Expected sum of 0 to n is n * (n + 1) / 2.
     * The missing number is exactly the difference between the expected sum and the actual sum.
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
