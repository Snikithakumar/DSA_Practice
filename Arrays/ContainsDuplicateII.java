import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * LeetCode #219 - Contains Duplicate II
     *
     * Given an integer array nums and an integer k, return true if there are two
     * distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     *
     * Sliding Window with HashSet:
     * Maintains a set representing a sliding window of size at most k.
     * Removes elements falling outside the window range (index < i - k).
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(min(N, k)) to hold elements in the sliding window.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0) {
            return false;
        }

        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove element that has slid out of the window of size k
            if (i > k) {
                window.remove(nums[i - k - 1]);
            }

            // If element already exists in the current window of size k, a duplicate is found
            if (!window.add(nums[i])) {
                return true;
            }
        }

        return false;
    }
}
