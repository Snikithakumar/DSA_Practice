class Solution {
    /**
     * LeetCode #152 - Maximum Product Subarray
     *
     * Given an integer array nums, find a subarray that has the largest product,
     * and return the product.
     *
     * Time Complexity: O(N) where N is the length of nums.
     * Space Complexity: O(1) auxiliary space.
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // Multiplying by a negative number swaps maximum and minimum
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // Either start a new subarray at current, or extend previous product
            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
