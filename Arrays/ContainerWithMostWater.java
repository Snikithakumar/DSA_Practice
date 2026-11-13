class Solution {
    /**
     * LeetCode #11 - Container With Most Water
     *
     * Given an integer array height of length n, find two lines that together with the x-axis
     * form a container, such that the container contains the most water.
     *
     * Two-pointer greedy approach:
     * Start with widest container (left = 0, right = n - 1). Always move the pointer
     * pointing to the shorter vertical line, as moving the taller line can never produce
     * a larger area with a smaller width.
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxWater = Math.max(maxWater, width * minHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
