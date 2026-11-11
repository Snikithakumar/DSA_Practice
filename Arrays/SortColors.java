class Solution {
    /**
     * LeetCode #75 - Sort Colors
     *
     * Given an array nums with n objects colored red, white, or blue (0, 1, or 2),
     * sort them in-place so that objects of the same color are adjacent.
     *
     * Dutch National Flag 3-way partitioning algorithm:
     * - [0, low - 1] contains 0s
     * - [low, mid - 1] contains 1s
     * - [mid, high] unprocessed elements
     * - [high + 1, n - 1] contains 2s
     *
     * Time Complexity: O(N) single-pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
