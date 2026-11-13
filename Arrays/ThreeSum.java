import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * LeetCode #15 - 3Sum
     *
     * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Two-pointer approach on sorted array:
     * 1. Sort the input array.
     * 2. Iterate through each element as the first element of triplet.
     * 3. Skip duplicates for all three pointers to ensure uniqueness.
     *
     * Time Complexity: O(N^2) where N is the length of nums.
     * Space Complexity: O(1) auxiliary space (excluding output list).
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Since array is sorted, if nums[i] > 0, sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
